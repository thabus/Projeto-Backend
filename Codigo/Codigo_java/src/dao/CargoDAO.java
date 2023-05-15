package dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargoDAO {

    public void create(String[] args) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        
        String sql = "INSERT INTO cargo (nome, id_setor) VALUES (?,?)";
        
    }
    
}
