package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarConexao() {
        try {
            String sgbd = "mysql";
            String endereco = "localhost";
            String bd = "projeto-backend";
            String usuario = "root";
            String senha = "";

            Connection connection = DriverManager.getConnection(
            "jdbc:" + sgbd + "://" + endereco + "/" + bd + "?useTimezone=true&serverTimezone=UTC", usuario, senha);

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
          }
    }
}