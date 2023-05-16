import java.sql.SQLException;

import dao.ChamadoDAO;
import dao.UsuarioDAO;
import model.Chamado;
import model.Usuario;

public class App {
    public static void usuariodao(String[] args) throws SQLException{
        Usuario usuario1 = new Usuario("Aline", "aline@gmail.com", "ali123", "21911111111");

        UsuarioDAO usudao = new UsuarioDAO();
        usudao.create(usuario1);
      
    }


    public static void chamadodao (String[] args) throws SQLException{
        Chamado chamado1 = new Chamado("1234", "aberto", "Troca de Fonte", "Meu computador queimou", "123445","Amanda Senra", "amanda@gmail.com", "219121212131", "19_08_2023");

        ChamadoDAO chamadao = new ChamadoDAO();
        chamadao.create(chamado1);
      
    }

    
}
