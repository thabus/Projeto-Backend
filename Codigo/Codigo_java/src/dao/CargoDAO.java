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

        String sql = "INSERT INTO cargo (nome, id_setor) VALUES (?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1, cargo.getNome());
            pstm.setInt(2, cargo.getIdSetor());

            connection.close();
            return pstm.execute();
        }
    }

    public ArrayList<Cargo> retriveAll() throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();

        stm.execute("SELECT * FROM cargo");
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
}
