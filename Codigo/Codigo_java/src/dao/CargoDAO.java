package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cargo;

public class CargoDAO {
    
    public Cargo getByNome(String nome) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        String sql = "SELECT * FROM cargo WHERE nome = ? ";

        try(PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setString(1, nome);
            ResultSet rst = pstm.executeQuery();
            Cargo cargo = null;
            if (rst.next()){
                cargo = new Cargo(rst.getString("nome"), ((Cargo) rst).getIdSetor());
                
                connection.close();

                return cargo;
            }

            return cargo;
        }

       
    }
}
