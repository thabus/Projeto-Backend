package controle;
import dao.ChamadoDAO;
import dao.ConnectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChamadoControle {
    //lista de chamados
    private Connection connection;

    public ChamadoControle(Connection connection){
        ConnectionFactory fabricaDeConexao = new ConnectionFactory();
        this.connection = fabricaDeConexao.recuperarConexao();
        this.chamadoDAO(connection);
    }

    private void chamadoDAO(Connection connection) {
    }

    public ArrayList<ChamadoDAO> getChamadosUsuarios(Usuario A) throws SQLException{
        ChamadoDAO tdao = new ChamadoDAO(this.connection);
        return tdao.retriveAllUsuario(A);
    }



}
