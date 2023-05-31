package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Setor;

public class SetorDao {
    
    public Setor getById() throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        String sql = "SELECT * FROM setor WHERE id = ? ";

         try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
             pstm.setInt(1, id);
             ResultSet rst = pstm.executeQuery();
             Setor setor = null;
             if (rst.next()) {
                 setor = new Setor(rst.getInt("id"), rst.getString("nome"));         
                
             connection.close();

             return setor;
         }
        
        return null;

        }
    }
}