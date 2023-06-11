package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cargo;
import model.Setor;

public class CargoDAO {

    private Connection connection;

    public CargoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Cargo getById(int id) {
        Cargo cargo = null;

        try {
            String sql = "SELECT * FROM cargo WHERE id = ?";

            try(PreparedStatement pstm = connection.prepareStatement(sql)){
                pstm.setInt(1, id);
                ResultSet rst = pstm.executeQuery();
                while (rst.next()){

                    int cargoID = rst.getInt("id");
                    String nome = rst.getString("nome");
                    int setorID = rst.getInt("id_setor");

                    SetorDAO setorDAO = new SetorDAO(connection);
                    Setor setor = setorDAO.getById(setorID);

                    cargo = new Cargo(cargoID, nome, setor);
                }
            }
            return cargo;
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
}
