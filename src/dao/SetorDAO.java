package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Setor;

public class SetorDAO {

    private Connection connection;

    public SetorDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Setor getById(int id) {

        Setor setor = null;
        try {
            String sql = "SELECT * FROM setor WHERE id = ?";

            try(PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
                pstm.setInt(1, id);
                ResultSet rst = pstm.executeQuery();
                while (rst.next()){
                    setor = new Setor(rst.getInt("id"), rst.getString("nome"));
                }
            }
            return setor;
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
}
