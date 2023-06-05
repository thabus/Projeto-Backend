package controle;
import dao.ChamadoDAO;
import dao.ConnectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.util.ArrayList;

public class ChamadoControle {
    //lista de chamados
    private ChamadoDAO chamadoDAO;

    public ChamadoControle(){
        ConnectionFactory fabricaDeConexao = new ConnectionFactory();
        Connection connection = fabricaDeConexao.recuperarConexao();
        this.chamadoDAO(connection);

    }

    private void chamadoDAO(Connection connection) {
    }

    //public ArrayList<Chamado> getChamadosUsuarios(Usuario A){
    //    ChamadoDAO tdao = new ChamadoDAO(this.connection);
    //    return tdao.retriveAllUsuario(A);

    //}


}
