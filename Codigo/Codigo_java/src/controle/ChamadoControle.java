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


    // Chamado chamado1 = new Chamado(1234, "aberto", "Troca de Fonte", "Meu computador queimou", 123445,"Amanda Senra", "amanda@gmail.com", "219121212131", LocalDate.of(2023, 8, 19));
    // ChamadoDAO chamadao = new ChamadoDAO(connection);

    //chamadao.create(chamado1);



}
