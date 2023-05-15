package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaDelecao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        stm.execute("DELETE FROM projetos WHERE numero > 0");
        Integer linhasModificadas = stm.getUpdateCount();
        System.out.println("Linhas modificadas: " + linhasModificadas);
        connection.close();
    }

}
