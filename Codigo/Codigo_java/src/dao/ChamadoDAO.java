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

}
