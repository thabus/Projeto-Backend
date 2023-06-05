import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.ChamadoDAO;
import dao.UsuarioDAO;
import model.Chamado;
import model.Usuario;

public class Main {
    Connection connection;

    public static void main(String[] args) throws SQLException {

        Usuario usuario1 = new Usuario("Lucas", "lucas@gmail.com", "luca111", "123456");
        UsuarioDAO udao = new UsuarioDAO();

        // udao.create(usuario1);

        udao.delete(usuario1);

        ArrayList<Usuario> usuariosAcesso = new ArrayList<Usuario>(udao.retriveAcesso("thiago@gmail.com", "thi123"));
        ArrayList<Usuario> usuariosAll = new ArrayList<Usuario>(udao.retriveAll());

        for (Usuario usuario : usuariosAll) {
            System.out.println(usuario);
        }

   

        Usuario usuarioA = new Usuario(3,"Thiago Alencar", "thiago@gmail.com", "thi123","21911111122");
        udao.update(usuarioA);
    }

    //Fazer select dos requisitos aqui na main
    //selec count from chamados where "total de chamaods"
    //select do usuario pelo email
    //create usuario
    //selec count from chamados where = true
    //selec count from chamados where = "setor ti" group by status
    //select count from chamados where "setor TI" end status atendido group by id do funcionario
}
