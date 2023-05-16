package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Chamado;

public class ChamadoDAO {

    public boolean create(Chamado chamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "INSERT INTO chamado (protocolo, status, titulo, descricao, id_usuario, nome_solicitante, email_solicitante, telefone_solicitante, data_abertura) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1, chamado.getProtocolo());
            pstm.setString(2, chamado.getStatus());
            pstm.setString(3, chamado.getTitulo());
            pstm.setString(4, chamado.getDescricao());
            pstm.setInt(5, chamado.getIdUsuario());
            pstm.setString(6, chamado.getNomeSolicitante());
            pstm.setString(7, chamado.getEmailSolicitante());
            pstm.setString(8, chamado.getTelefoneSolicitante());
            pstm.setDate(9, chamado.getDataAbertura());

            connection.close();
            return pstm.execute();
        }    
    }

    public boolean delete(Chamado chamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "DELETE FROM chamado WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1, chamado.getProtocolo());
            pstm.execute();
            if (pstm.execute() == false) {
                System.out.println("Chamado não encontrado.");
            } else {
                System.out.println("Chamado excluído com sucesso.");
            }
            connection.close();

            return pstm.execute();  
        }
    }
    
    public Chamado getByProtocolo(int protocolo) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        String sql = "SELECT * FROM chamado WHERE protocolo = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(1, protocolo);
            ResultSet rst = pstm.executeQuery();
          Chamado chamado = null;
            if (rst.next()) {
                chamado = new Chamado(rst.getInt("protocolo"), rst.getString("status"), rst.getString("titulo"), rst.getString("descricao"), rst.getInt("id_usuario"), rst.getString("nome_solicitante"), rst.getString("email_solicitante"), rst.getString("telefone_solicitante"), rst.getDate("data_abertura"));
            }

            return chamado;        
        }

    }
}
