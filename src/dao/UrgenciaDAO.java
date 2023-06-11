package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Urgencia;

public class UrgenciaDAO {

    private Connection connection;

    public UrgenciaDAO(Connection connection) {
        this.connection = connection;
    }

    public Urgencia getByEscala(int escala) {

        Urgencia urgencia = null;
        try {
            String sql = "SELECT * FROM urgencia WHERE escala = ?";

            try(PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
                pstm.setInt(1, escala);
                ResultSet rst = pstm.executeQuery();
                while (rst.next()){
                    urgencia = new Urgencia(rst.getInt("escala"), rst.getInt("dias"));
                }
            }
            return urgencia;
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
}
