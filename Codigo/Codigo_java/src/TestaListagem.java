// import java.sql.SQLException;
// import java.sql.Statement;
// import java.sql.Connection;
// import java.sql.ResultSet;

// public class TestaListagem {
//     public static void main(String[] args) throws SQLException{
//         CriaConexao criaConexao = new CriaConexao();
//         Connection connection = criaConexao.recuperarConexao();
//         Statement stm = connection.createStatement();
//         boolean resultado = stm.execute("SELECT protocolo FROM chamados");
//         ResultSet rst = stm.getResultSet();
//         while(rst.next()){
//             Integer id = rst.getInt("protocolo");
//             System.out.println(id);
//             String titulo = rst.getString("titulo");
//             System.out.println(titulo);
//         }
//         connection.close();
//     }
// }
