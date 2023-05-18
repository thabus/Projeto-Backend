import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;


import dao.ChamadoDAO;
import dao.UsuarioDAO;
import model.Cargo;
import model.Chamado;
import model.Setor;
import model.Usuario;

public class Main {
    public static void main(String[] args) throws SQLException {

        

    }

    public static void testeChamadoDAO() throws SQLException {
        Chamado chamado1 = new Chamado(1234, "aberto", "Troca de Fonte", "Meu computador queimou", 123445,"Amanda Senra", "amanda@gmail.com", "219121212131", new Date(2023, 8, 19));
        ChamadoDAO chamadao = new ChamadoDAO();

        chamadao.create(chamado1);
    }

    public static void testeUsuarioDAO() throws SQLException {
        Usuario usuario1 = new Usuario("Aline", "aline@gmail.com", "ali123", "21911111111");
        UsuarioDAO udao = new UsuarioDAO();

        udao.create(usuario1);
    }
}
