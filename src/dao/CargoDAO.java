package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Cargo;
import model.Chamado;
import model.Setor;
import model.Usuario;

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

    public Cargo getCargoByUsuario(Usuario usuario) {
        Cargo cargo = null;

        try {
            String sql = "SELECT cargo FROM usuario WHERE email = ? AND senha = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {

                pstm.setString(1, usuario.getEmail());
                pstm.setString(2, usuario.getSenha());
                ResultSet rst = pstm.executeQuery();

                while(rst.next()) {
                    int nome_cargo = rst.getInt("cargo");
                    CargoDAO cargoDAO = new CargoDAO(connection);
                    cargo = cargoDAO.getById(nome_cargo);
                }
            }
            return cargo;
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}

    }
}
