package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Chamado;
import model.Setor;
import model.Urgencia;
import model.Usuario;

public class ChamadoDAO {

    Connection connection;

    public ChamadoDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Chamado chamado) {
        try {
             String sql = "INSERT INTO chamados (id, status, titulo, descricao, id_usuario, data_abertura) VALUES (?, ?, ?, ?, ?, ?)";
 
             try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
 
                 pstm.setInt(1, chamado.getId());
                 pstm.setString(2, chamado.getStatus());
                 pstm.setString(3, chamado.getTitulo());
                 pstm.setString(4, chamado.getDescricao());
                 pstm.setInt(5, chamado.getUsuarioID().getId());
                 pstm.setObject(6, chamado.getDataAbertura());
 
                 pstm.execute();
 
                 try (ResultSet rst = pstm.getGeneratedKeys()) {
                     while (rst.next()) {
                         chamado.setId(rst.getInt(1));
                     }
                 }
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }

     public void delete(Chamado chamado) {
        try {
            String sql = "DELETE FROM chamados WHERE id = ?";
            try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setInt(1, chamado.getId());

                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Chamado getById(int id) {

        Chamado chamado = null;

        try {
            String sql = "SELECT * FROM chamados WHERE id = ?";
            
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, id);
                ResultSet rst = pstm.executeQuery();
                while (rst.next()) {

                    int chamadoID = rst.getInt("id");
                    String status = rst.getString("status");
                    String tipo = rst.getString("tipo");
                    String titulo = rst.getString("titulo");
                    String descricao = rst.getString("descricao");

                    SetorDAO setorDAO = new SetorDAO(connection);
                    Setor setor = setorDAO.getById(rst.getInt("id_setor"));
                    
                    UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                    Usuario usuario = usuarioDAO.getById(rst.getInt("id_usuario"));
                    
                    Usuario responsavel = usuarioDAO.getById(rst.getInt("id_responsavel"));
                    
                    LocalDate dataAbertura = rst.getObject("data_abertura", LocalDate.class);
                    LocalDate dataFechamento = rst.getObject("data_fechamento", LocalDate.class);
                    
                    UrgenciaDAO urgenciaDAO = new UrgenciaDAO(connection);
                    Urgencia urgencia = urgenciaDAO.getByEscala(rst.getInt("urgencia"));
                    
                    LocalDate prazo = rst.getObject("prazo", LocalDate.class);
                    
                    chamado = new Chamado(chamadoID, status, tipo, titulo, descricao, setor, usuario, responsavel, dataAbertura, dataFechamento, urgencia, prazo);
                }
            }
            return chamado;
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    public ArrayList<Chamado> retriveAll() {
        
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();

        try {
            String sql = "SELECT * FROM chamados";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();
                ResultSet rst = pstm.getResultSet();
                while(rst.next()) {
                    int id = rst.getInt("id");
                    String status = rst.getString("status");
                    String tipo = rst.getString("tipo");
                    String titulo = rst.getString("titulo");
                    String descricao = rst.getString("descricao");
                    int setorID = rst.getInt("id_setor");
                    int usuarioID = rst.getInt("id_usuario");
                    int responsavelID = rst.getInt("id_responsavel");
                    LocalDate dataAbertura = rst.getObject("data_abertura", LocalDate.class);
                    LocalDate dataFechamento = rst.getObject("data_fechamento", LocalDate.class);
                    int urgenciaID = rst.getInt("urgencia");
                    LocalDate prazo = rst.getObject("prazo", LocalDate.class);

                    SetorDAO setorDAO = new SetorDAO(connection);
                    Setor setor = setorDAO.getById(setorID);

                    UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                    Usuario usuario = usuarioDAO.getById(usuarioID);
                    Usuario responsavel = usuarioDAO.getById(responsavelID);

                    UrgenciaDAO urgenciaDAO = new UrgenciaDAO(connection);
                    Urgencia urgencia = urgenciaDAO.getByEscala(urgenciaID);

                    Chamado c = new Chamado(id, status, tipo, titulo, descricao, setor, usuario, responsavel, dataAbertura, dataFechamento, urgencia, prazo);
                    chamados.add(c);
                }
            }
            return chamados;
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    public void updateAll(Chamado chamado) {
        try {
            String sql = "UPDATE chamados SET status = ?, tipo = ?, titulo = ?, descricao = ?, id_setor = ?, id_usuario = ?, id_responsavel = ?, data_abertura = ?, data_fechamento = ?, urgencia = ?, prazo = ? WHERE id = ?";
            try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, chamado.getStatus());
                pstm.setString(2, chamado.getTipo());
                pstm.setString(3, chamado.getTitulo());
                pstm.setString(4, chamado.getDescricao());
                pstm.setObject(5, chamado.getSetorID().getId());
                pstm.setObject(6, chamado.getUsuarioID().getId());
                pstm.setObject(7, chamado.getResponsavelID().getId());
                pstm.setObject(8, chamado.getDataAbertura());
                pstm.setObject(9, chamado.getDataFechamento());
                pstm.setObject(10, chamado.getUrgencia().getEscala());
                pstm.setObject(11, chamado.getPrazo());
                pstm.setInt(12, chamado.getId());

                pstm.execute();
            }   
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(Chamado chamado) {
        try {
            String sql = "UPDATE chamados SET status = ? WHERE id = ?";
            try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, chamado.getStatus());
                pstm.setInt(2, chamado.getId());

                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateResponsavel(Chamado chamado) {
        try {
            String sql = "UPDATE chamados SET id_responsavel = ? WHERE id = ?";
            try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setObject(1, chamado.getResponsavelID().getId());
                pstm.setInt(2, chamado.getId());

                pstm.execute(); 
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTriagem(Chamado chamado) {
        try {
            String sql = "UPDATE chamados SET tipo = ?, id_setor = ?, urgencia = ? WHERE id = ?";
            try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

                pstm.setString(1, chamado.getTipo());
                pstm.setObject(2, chamado.getSetorID().getId());
                pstm.setObject(3, chamado.getUrgencia().getEscala());
                pstm.setInt(4, chamado.getId());

                pstm.execute();
                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


