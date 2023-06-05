package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cargo;
import model.Setor;
import model.Usuario;

public class UsuarioDAO {

    public boolean create(Usuario usuario) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "INSERT INTO usuario(nome, email, senha, cargo, setor, telefone) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.setObject(4, usuario.getCargo());
            pstm.setObject(5, usuario.getSetor());
            pstm.setString(6, usuario.getTelefone());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean delete(Usuario usuario) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1, usuario.getId());
            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public Usuario getById(int id) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rst = pstm.executeQuery();
            Usuario usuario = null;
            if (rst.next()) {
                usuario = new Usuario(rst.getInt("id"), rst.getString("nome"), rst.getString("email"), rst.getString("senha"), rst.getObject("cargo", Cargo.class), rst.getObject("setor", Setor.class), rst.getString("telefone"));
            }

            return usuario;
        }
    }

    public ArrayList<Usuario> retriveAll() throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        String sql = "SELECT * FROM usuario";

        stm.execute(sql);
        ResultSet rst = stm.getResultSet();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        while (rst.next()){
            int id = rst.getInt("id");
            String nome = rst.getString("nome");
            String email = rst.getString("email");
            String senha = rst.getString("senha");
            String nome_cargo = rst.getString("cargo");
            CargoDAO cdao = new CargoDAO();
            Cargo cargo = cdao.getByNome(nome_cargo);
            int id_setor = rst.getInt("setor");
            SetorDao sdao = new SetorDao();
            Setor setor = sdao.getById(id_setor);
            String telefone = rst.getString("telefone");

            Usuario u = new Usuario(id, nome, email, senha, cargo, setor, telefone);
            usuarios.add(u);
        }
        connection.close();

        return usuarios;
    }

    public ArrayList<Usuario> retriveAcesso(String email, String senha) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setString(1, email);
            pstm.setString(2, senha);
            ResultSet rst = pstm.executeQuery();
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

            if (rst.next()){
                int id = rst.getInt("id");
                String nome = rst.getString("nome");
                String e_mail = rst.getString("email");
                String senha_recupera = rst.getString("senha");
                String nome_cargo = rst.getString("cargo");
                CargoDAO cdao = new CargoDAO();
                Cargo cargo = cdao.getByNome(nome_cargo);
                int id_setor = rst.getInt("setor");
                SetorDao sdao = new SetorDao();
                Setor setor = sdao.getById(id_setor);
                String telefone = rst.getString("telefone");

                Usuario u = new Usuario(id, nome, e_mail, senha_recupera, cargo, setor, telefone);
                usuarios.add(u);


                connection.close();

               return usuarios;
            }

            return usuarios;
        }
    }



    public boolean update(Usuario usuario) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, cargo = ?, setor = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.setObject(4, usuario.getCargo());
            pstm.setObject(5, usuario.getSetor());
            pstm.setString(6, usuario.getTelefone());
            pstm.setInt(7, usuario.getId());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }
}
