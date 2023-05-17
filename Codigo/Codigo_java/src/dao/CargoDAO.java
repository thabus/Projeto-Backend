package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cargo;

public class CargoDAO {

    public boolean create(Cargo cargo) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "INSERT INTO cargo (nome, id_setor) VALUES (?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1, cargo.getNome());
            pstm.setInt(2, cargo.getIdSetor());
            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean delete(Cargo cargo) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "DELETE FROM cargo WHERE nome = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1, cargo.getNome());
            sucesso = pstm.execute();

            connection.close();

            return sucesso;
        }
    }

    public Cargo getByNome(String nome) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        String sql = "SELECT * FROM cargo WHERE nome = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1, nome);
            ResultSet rst = pstm.executeQuery();
            Cargo cargo = null;
            if (rst.next()) {
                cargo = new Cargo(rst.getString("nome"), rst.getInt("id_setor"));
            }
            connection.close();

            return cargo;
        }
    }

    public ArrayList<Cargo> retriveAll() throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        String sql = "SELECT * FROM cargo";

        stm.execute(sql);
        ResultSet rst = stm.getResultSet();
        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        while (rst.next()){
            String nome = rst.getString("nome");
            int idSetor = rst.getInt("id_setor");
            Cargo c = new Cargo(nome, idSetor);
            cargos.add(c);
        }
        connection.close();

        return cargos;
    }

    public boolean update(Cargo cargo) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE cargo SET id_setor = ? WHERE nome = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1, cargo.getIdSetor());
            pstm.setString(2, cargo.getNome());
            sucesso = pstm.execute();

            connection.close();

            return sucesso;
        }
    }
}

