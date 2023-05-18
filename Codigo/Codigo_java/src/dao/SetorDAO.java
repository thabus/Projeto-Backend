//
// EXCLUIR CARGODAO E SETORDAO
//


// package dao;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;

// import model.Setor;

// public class SetorDAO {

//     public boolean create(Setor setor) throws SQLException {
//         CriaConexao criaConexao = new CriaConexao();
//         Connection connection = criaConexao.recuperarConexao();
//         boolean sucesso = false;

//         String sql = "INSERT INTO setor (nome, localizacao, gerente_id) VALUES (?, ?, ?)";
//         try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
//             pstm.setString(1, setor.getNome());
//             pstm.setString(2, setor.getLocalizacao());
//             pstm.setInt(3, setor.getGerente());

//             sucesso = pstm.execute();
//             connection.close();
//             return sucesso;
//         }
//     }

//     public boolean delete(Setor setor) throws SQLException {
//         CriaConexao criaConexao = new CriaConexao();
//         Connection connection = criaConexao.recuperarConexao();
//         boolean sucesso = false;

//         String sql = "DELETE FROM setor WHERE id = ?";
//         try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
//             pstm.setInt(1, setor.getId());
            
//             sucesso = pstm.execute();
//             connection.close();
//             return sucesso;
//         }
//     }

//     public Setor getById(int id) throws SQLException {
//         CriaConexao criaConexao = new CriaConexao();
//         Connection connection = criaConexao.recuperarConexao();
//         String sql = "SELECT * FROM setor WHERE id = ?";

//         try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
//             pstm.setInt(1, id);
//             ResultSet rst = pstm.executeQuery();
//             Setor setor = null;
//             if (rst.next()) {
//                 setor = new Setor(rst.getInt("id"), rst.getString("nome"), rst.getString("localizacao"), rst.getInt("gerente_id"));
//             }
//             connection.close();

//             return setor;
//         } 
//     }

//     public ArrayList<Setor> retriveAll() throws SQLException {
//         CriaConexao criaConexao = new CriaConexao();
//         Connection connection = criaConexao.recuperarConexao();
//         Statement stm = connection.createStatement();
//         String sql = "SELECT * FROM setor";

//         stm.execute(sql);
//         ResultSet rst = stm.getResultSet();
//         ArrayList<Setor> setores = new ArrayList<Setor>();
//         while (rst.next()){
//             int id = rst.getInt("id");
//             String nome = rst.getString("nome");
//             String localizacao = rst.getString("localizacao");
//             int gerenteId = rst.getInt("gerente_id");

//             Setor s = new Setor(id, nome, localizacao, gerenteId);
//             setores.add(s);
//         }
//         connection.close();

//         return setores;
//     }

//     public boolean update(Setor setor) throws SQLException {
//         CriaConexao criaConexao = new CriaConexao();
//         Connection connection = criaConexao.recuperarConexao();
//         boolean sucesso = false;

//         String sql = "UPDATE setor SET nome = ?, localizacao = ?, gerente_id = ? WHERE id = ?";
//         try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
//             pstm.setString(1, setor.getNome());
//             pstm.setString(2, setor.getLocalizacao());
//             pstm.setInt(3, setor.getGerente());
//             pstm.setInt(4, setor.getId());
            
//             sucesso = pstm.execute();
//             connection.close();
//             return sucesso;
//         }
//     }
// }