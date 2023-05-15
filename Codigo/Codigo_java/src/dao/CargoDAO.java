package dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class CargoDAO throws SQLException {
    CriaConexao criaConexao = new CriaConexao();
    Connection connection = criaConexao.recuperarConexao();
    Statement stm = connection.createStatement();
}
