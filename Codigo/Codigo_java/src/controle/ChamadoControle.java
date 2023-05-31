package controle;
import dao.ChamadoDAO;
import dao.ConnectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.util.ArrayList;

public class ChamadoControle {
    //lista de chamados
    private Connection connection;

    public ChamadoControle(Connection connection){
        ConnectionFactory fabricaDeConexao = new ConnectionFactory();
        this.connection = fabricaDeConexao.recuperarConexao();
    }

    public ArrayList<Chamado> getChamadosUsuarios(Usuario A){
        ChamadoDAO tdao = new ChamadoDAO(this.connection);
        return tdao.retriveAllUsuario(A);

    }

    
}
