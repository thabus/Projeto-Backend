package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cargo;
import model.Usuario;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuario (nome, email, senha, cargo, telefone) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getEmail());
                pstm.setString(3, usuario.getSenha());
                pstm.setInt(4, usuario.getCargo().getId());
                pstm.setString(5, usuario.getTelefone());
    
                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        usuario.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Usuario usuario) {
        try {
            String sql = "DELETE FROM usuario WHERE id = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, usuario.getId());
                pstm.execute();
            }
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    public Usuario getById(int id) {

        Usuario usuario = null;

        try {
            String sql = "SELECT * FROM usuario WHERE id = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, id);
                ResultSet rst = pstm.executeQuery();
                while (rst.next()) {

                    int usuarioID = rst.getInt("id");
                    String nome = rst.getString("nome");
                    String email = rst.getString("email");
                    String senha = rst.getString("senha");
                    String telefone = rst.getString("telefone");

                    int cargoID = rst.getInt("cargo");
                    CargoDAO cargoDAO = new CargoDAO(connection);
                    Cargo cargo = cargoDAO.getById(cargoID);

                    usuario = new Usuario(usuarioID, nome, email, senha, cargo, telefone);
                } 
            }
            return usuario;
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    public ArrayList<Usuario> retriveAll() {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            String sql = "SELECT * FROM usuario";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();
                ResultSet rst = pstm.getResultSet();
                while(rst.next()) {
                    int id = rst.getInt("id");
                    String nome = rst.getString("nome");
                    String email = rst.getString("email");
                    String senha = rst.getString("senha");
                    int cargoID = rst.getInt("cargo");

                    CargoDAO cargoDAO = new CargoDAO(connection);
                    Cargo cargo = cargoDAO.getById(cargoID);
                    
                    String telefone = rst.getString("telefone");

                    Usuario u = new Usuario(id, nome, email, senha, cargo, telefone);
                    usuarios.add(u);
                }
            }
            return usuarios;
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    public ArrayList<Usuario> retriveAcesso(String email, String senha) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {

                pstm.setString(1, email);
                pstm.setString(2, senha);
                ResultSet rst = pstm.executeQuery();

                while(rst.next()) {
                    int id = rst.getInt("id");
                    String nome = rst.getString("nome");
                    String e_mail = rst.getString("email");
                    String senha_recupera = rst.getString("senha");
                    int nome_cargo = rst.getInt("cargo");

                    CargoDAO cargoDAO = new CargoDAO(connection);
                    Cargo cargo = cargoDAO.getById(nome_cargo);

                    String telefone = rst.getString("telefone");

                    Usuario u = new Usuario(id, nome, e_mail, senha_recupera, cargo, telefone);
                    usuarios.add(u);
                }
            }
            return usuarios;
        } catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    public void update(Usuario usuario) {

        try {
            String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, telefone = ? WHERE id = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getEmail());
                pstm.setString(3, usuario.getSenha());
                pstm.setString(4, usuario.getTelefone());
                pstm.setInt(5, usuario.getId());

                pstm.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
