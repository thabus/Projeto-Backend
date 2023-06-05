package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Chamado;
import model.Usuario;

public class ChamadoDAO {

    Connection connection;

    public ChamadoDAO(Connection connection) throws SQLException{
        this.connection = connection;
    }


    public ChamadoDAO() {
    }


    public boolean create(Chamado chamados) throws SQLException {

        boolean sucesso = false;

        String sql = "INSERT INTO chamados (protocolo, status, titulo, descricao, id_usuario, nome_solicitante, email_solicitante, telefone_solicitante, data_abertura) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1, chamados.getProtocolo());
            pstm.setString(2, chamados.getStatus());
            pstm.setString(3, chamados.getTitulo());
            pstm.setString(4, chamados.getDescricao());
            pstm.setInt(5, chamados.getIdUsuario());
            pstm.setString(6, chamados.getNomeSolicitante());
            pstm.setString(7, chamados.getEmailSolicitante());
            pstm.setString(8, chamados.getTelefoneSolicitante());
            pstm.setObject(9, chamados.getDataAbertura());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean delete(Chamado chamados) throws SQLException {

        boolean sucesso = false;

        String sql = "DELETE FROM chamados WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1, chamados.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public Chamado getByProtocolo(int protocolo) throws SQLException {

        String sql = "SELECT * FROM chamados WHERE protocolo = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(1, protocolo);
            ResultSet rst = pstm.executeQuery();
            Chamado chamados = null;
            if (rst.next()) {
                chamados = new Chamado(rst.getInt("protocolo"), rst.getString("status"), rst.getInt("id_setor"), rst.getString("tipo"),rst.getString("titulo"), rst.getString("descricao"), rst.getInt("id_usuario"), rst.getString("nome_solicitante"), rst.getString("email_solicitante"), rst.getString("telefone_solicitante"), rst.getInt("id_responsavel"), rst.getObject("data_abertura", LocalDate.class), rst.getObject("data_fechamento", LocalDate.class), rst.getObject("prazo", LocalDate.class), rst.getObject("data_prazo", LocalDate.class), rst.getInt("urgencia"));
            }
            connection.close();

            return chamados;
        }
    }

    public ArrayList<Chamado> retriveAll() throws SQLException {

        Statement stm = connection.createStatement();
        String sql = "SELECT * FROM chamados";

        stm.execute(sql);
        ResultSet rst = stm.getResultSet();
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        while (rst.next()){
            int protocolo = rst.getInt("protocolo");
            String status = rst.getString("status");
            int idSetor = rst.getInt("id_setor");
            String tipo = rst.getString("tipo");
            String titulo = rst.getString("titulo");
            String descricao = rst.getString("descricao");
            int idUsuario = rst.getInt("id_usuario");
            String nomeSolicitante = rst.getString("nome_solicitante");
            String emailSolicitante = rst.getString("email_solicitante");
            String telefoneSolicitante = rst.getString("telefone_solicitante");
            int idResponsavel = rst.getInt("id_responsavel");
            LocalDate dataAbertura = rst.getObject("data_abertura", LocalDate.class);
            LocalDate dataFechamento = rst.getObject("data_fechamento", LocalDate.class);
            LocalDate prazo = rst.getObject("prazo", LocalDate.class);
            LocalDate dataPrazo = rst.getObject("data_prazo", LocalDate.class);
            int urgencia = rst.getInt("urgencia");

            Chamado c = new Chamado(protocolo, status, idSetor, tipo, titulo, descricao, idUsuario, nomeSolicitante, emailSolicitante, telefoneSolicitante, idResponsavel, dataAbertura, dataFechamento, prazo, dataPrazo, urgencia);
            chamados.add(c);
        }
        connection.close();

        return chamados;
    }

    public boolean updateAll(Chamado chamados) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE chamados SET status = ?, id_setor = ?, tipo = ?, titulo = ?, descricao = ?, id_usuario = ?, nome_solictante = ?, email_solicitante = ?, telefone_solictante = ?, id_responsavel = ?, data_abertura = ?, data_fechamento = ?, urgencia = ?, prazo = ?, data_prazo = ? WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

            pstm.setString(1, chamados.getStatus());
            pstm.setInt(2, chamados.getIdSetor());
            pstm.setString(3, chamados.getTipo());
            pstm.setString(4, chamados.getTitulo());
            pstm.setString(5, chamados.getDescricao());
            pstm.setInt(6, chamados.getIdUsuario());
            pstm.setString(7, chamados.getNomeSolicitante());
            pstm.setString(8, chamados.getEmailSolicitante());
            pstm.setString(9, chamados.getTelefoneSolicitante());
            pstm.setInt(10, chamados.getIdResponsavel());
            pstm.setObject(11, chamados.getDataAbertura());
            pstm.setObject(12, chamados.getDataFechamento());
            pstm.setInt(13, chamados.getUrgencia());
            pstm.setObject(14, chamados.getPrazo());
            pstm.setObject(15, chamados.getDataPrazo());
            pstm.setInt(16, chamados.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean updateStatus(Chamado chamados) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE chamados SET status = ? WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

            pstm.setString(1, chamados.getStatus());
            pstm.setInt(2, chamados.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean updateResponsavel(Chamado chamados) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE chamados id_responsavel = ? WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

            pstm.setInt(1, chamados.getIdResponsavel());
            pstm.setInt(2, chamados.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean updateTriagem(Chamado chamados) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE chamados SET id_setor = ?, tipo = ?, urgencia = ? WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

            pstm.setInt(1, chamados.getIdSetor());
            pstm.setString(2, chamados.getTipo());
            pstm.setInt(3, chamados.getUrgencia());
            pstm.setInt(4, chamados.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }


    public ArrayList<ChamadoDAO> retriveAllUsuario(Usuario a) {
        return null;
    }
}


