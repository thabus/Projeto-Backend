import java.sql.SQLException;
import dao.UsuarioDAO;
import model.Usuario;

public class App {
    public static void main(String[] args) throws SQLException{
        Usuario usuario1 = new Usuario("Aline", "aline@gmail.com", "ali123", "21911111111");

        UsuarioDAO usudao = new UsuarioDAO();
        usudao.create(usuario1);
      
    }
}
