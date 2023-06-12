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

        // System.out.println(cargodao.getById(2));

        

        // ---------------------- USUÁRIO ----------------------

        Usuario usuario = new Usuario(21, "Criação Teste", "criação.teste1@example.com", "senhaCria", cargo,"(11) 98765-3333");
        Usuario usuarioResponsavel = new Usuario(11, "Criação Teste2", "criação.teste2@example.com", "senhaCria2", cargo,"(11) 95432-3333");
        Usuario usuarioDelete = new Usuario(24, "Criação Delete", "criação.teste2@example.com", "senhaCria2", cargo,"(11) 95432-3333");
        Usuario usuarioUpdate = new Usuario(21, "Update Teste", "update.teste1@example.com", "senhaUp", cargo,"(11) 98765-3333");

        // System.out.println(udao.getById(1));
        // udao.create(usuarioDelete);
        // udao.delete(usuarioDelete);
        // udao.update(usuarioUpdate);

        ArrayList<Usuario> usuariosAcesso = new ArrayList<Usuario>(udao.retriveAcesso("ana.souza@example.com", "senhaqwe"));
        ArrayList<Usuario> usuariosAll = new ArrayList<Usuario>(udao.retriveAll());

        // for (Usuario usuariot : usuariosAll) {
        //     System.out.println(usuariot);
        // }



        // ---------------------- CHAMADO ----------------------

        Chamado chamado = new Chamado(13, "Pendente", "Título Criação1", "Descrição Criação 1", usuario, LocalDate.now());
        Chamado chamadoDelete = new Chamado(15, "Delete", "Título Delete", "Descrição Delete 1", usuario, LocalDate.now());

        // System.out.println(cdao.getById(1));
        // cdao.create(chamadoDelete);
        // cdao.delete(chamadoDelete);

        Chamado cUpdateTriagem = new Chamado(13, "Tipo - Exemplo 4", setor, urgencia);
        Chamado cUpdateResp = new Chamado(13, usuario);
        Chamado cUpdateStatus = new Chamado(13, "Aberto");
        Chamado cUpdateAll = new Chamado(13, "Aberto", "Tipo - Exemplo 4", "Título Update", "Descrição Update 1", setor, usuario, usuarioResponsavel, LocalDate.of(2023, 06, 10), null, urgencia, LocalDate.of(2023, 06, 15));

        // cdao.updateAll(cUpdateAll);
        
        ArrayList<Chamado> chamadosAll = new ArrayList<Chamado>(cdao.retriveAll());

        // for (Chamado chamadot : chamadosAll) {
        //     System.out.println(chamadot);
        // }
    }
}
