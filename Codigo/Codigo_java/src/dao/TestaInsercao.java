package dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = (Statement) connection.createStatement();
        stm.execute("INSERT INTO urgencia (dias, escala) VALUES (10, 5)", Statement.RETURN_GENERATED_KEYS);
        ResultSet rst = ((java.sql.Statement) stm).getGeneratedKeys();
        while(rst.next()){
            Integer dias = getInt("dias");
            System.out.println(dias);
            Integer escala = getInt("escala");
            System.out.println(escala);
        }
        connection.close();
    }

    private static Integer getInt(String string) {
        return null;
    }

}
