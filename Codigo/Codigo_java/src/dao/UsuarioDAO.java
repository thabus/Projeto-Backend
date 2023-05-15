package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
    
    public boolean create(Usuario usuario) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "INSERT INTO usuario(nome, email, senha, telefone) VALUES (?,?,?,?)";
        try(PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.setString(4, usuario.getTelefone());


            //connection.close();
            return pstm.execute();

        }
    }


}
