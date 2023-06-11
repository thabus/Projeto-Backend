import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.CargoDAO;
import dao.ChamadoDAO;
import dao.ConnectionFactory;
import dao.SetorDAO;
import dao.UrgenciaDAO;
import dao.UsuarioDAO;
import model.Cargo;
import model.Chamado;
import model.Setor;
import model.Urgencia;
import model.Usuario;

// TESTE 11/06: TODOS MÉTODOS FUNCIONANDO

public class Main {
    static Connection connection;

    public static void main(String[] args) throws SQLException {

        ConnectionFactory fabricaDeConexao = new ConnectionFactory();
        Connection connection = fabricaDeConexao.recuperarConexao();

        UsuarioDAO udao = new UsuarioDAO(connection);
        ChamadoDAO cdao = new ChamadoDAO(connection);
        SetorDAO setordao = new SetorDAO(connection);
        CargoDAO cargodao = new CargoDAO(connection);
        UrgenciaDAO urgenciadao = new UrgenciaDAO(connection);

        Setor setor = new Setor(1, "TI");
        Cargo cargo = new Cargo(1, "Analista TI", setor);
        Urgencia urgencia = new Urgencia(1, 5);

        Usuario usuario = new Usuario(21, "Criação Teste", "criação.teste1@example.com", "senhaCria", cargo,"(11) 98765-3333");
        Usuario usuarioResp = new Usuario(11, "Criação Teste2", "criação.teste2@example.com", "senhaCria2", cargo,"(11) 95432-3333");
        Usuario usuarioDelete = new Usuario(24, "Criação Delete", "criação.teste2@example.com", "senhaCria2", cargo,"(11) 95432-3333");

        Usuario uUpdate = new Usuario(21, "Update Teste", "update.teste1@example.com", "senhaUp", cargo,"(11) 98765-3333");

        // udao.create(usuarioDelete);

        // udao.delete(usuarioDelete);

        // udao.update(uUpdate);

        Chamado chamado = new Chamado(13, "Pendente", "Título Criação1", "Descrição Criação 1", usuario, LocalDate.now());

        Chamado chamadoDelete = new Chamado(15, "Delete", "Título Delete", "Descrição Delete 1", usuario, LocalDate.now());

        // cdao.create(chamadoDelete);

        // cdao.delete(chamadoDelete);

        Chamado cUpdateTriagem = new Chamado(13, "Tipo - Exemplo 4", setor, urgencia);

        Chamado cUpdateResp = new Chamado(13, usuario);

        Chamado cUpdateStatus = new Chamado(13, "Aberto");

        Chamado cUpdateAll = new Chamado(13, "Aberto", "Tipo - Exemplo 4", "Título Update", "Descrição Update 1", setor, usuario, usuarioResp, LocalDate.of(2023, 06, 10), null, urgencia, LocalDate.of(2023, 06, 15));

        // cdao.updateAll(cUpdateAll);



        // System.out.println(cdao.getById(1));
        // System.out.println(cdao.getById(1));

        // Usuario usuario1 = new Usuario("Nick", "nicolas@gmail.com", "nick222", "222333");

        // udao.create(usuario1);

        // udao.delete(usuario1);

        // ArrayList<Usuario> usuariosAcesso = new ArrayList<Usuario>(udao.retriveAcesso("ana.souza@example.com", "senhaqwe"));
        //ArrayList<Usuario> usuariosAll = new ArrayList<Usuario>(udao.retriveAll());
        // ArrayList<Chamado> chamadosAll = new ArrayList<Chamado>(cdao.retriveAll());

        // for (Usuario usuario : usuariosAcesso) {
        //     System.out.println(usuario);
        // }

        // udao.delete(usuario1); //

        // System.out.println(cdao.getByProtocolo(1234)); 

        // for (Chamado chamado : chamadosAll) {
        //     System.out.println(chamado);
        // }

        //System.out.println(udao.getById(1));

        // System.out.println(cargodao.getById(2));
        

   

        // Usuario usuarioA = new Usuario(3,"Thiago Alencar", "thiago@gmail.com", "thi123","21911111122");
        // udao.update(usuarioA);
    }
}
