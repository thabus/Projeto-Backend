import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import controler.ChamadoControle;
import controler.UsuarioControle;
import model.Cargo;
import model.Chamado;
import model.Setor;
import model.Urgencia;
import model.Usuario;

public class Main {
    static Connection connection;
    
    public static void main(String[] args) throws SQLException {

        Setor setor = new Setor(1, "TI");
        Cargo cargo = new Cargo(1, "Analista TI", setor);
        Urgencia urgencia = new Urgencia(1, 5);

        ChamadoControle cControle = new ChamadoControle();
        UsuarioControle uControle = new UsuarioControle();

        // USUÁRIOS: CRIANDO OBJETOS

        Usuario usuarioCreate = new Usuario(21, "Vitor Lobianco", "vitor.lobianco@exemplo.com", "vitor123", cargo, "(21) 992471219");
        Usuario usuarioUpdate = new Usuario(21, "Atualizado", "atualizado@exemplo.com", "att123", cargo, "(21) 990000000");
        Usuario usuarioDelete = uControle.getUsuarioById(usuarioCreate.getId());

        // USUÁRIOS: MÉTODOS

        // uControle.createUsuario(usuarioCreate); // rafaela.santos@example.com - senha456

        // uControle.updateAllUsuario(usuarioUpdate);

        // System.out.println(uControle.getUsuarioJsonById(21));

        // System.out.println(uControle.retriveAllUsuarios());

        // uControle.deleteUsuario(usuarioDelete); // rafaela.santos@example.com - senha456

        // CHAMADOS: CRIANDO OBJETOS 

        Chamado chamadoCreate = new Chamado(17, "Pendente", "Título Exemplo", "Descrição Exemplo", uControle.getUsuarioById(7), LocalDate.of(2023, 06, 18));
        Chamado updateTriagem = new Chamado(17, "Tipo Exemplo", setor, urgencia);
        Chamado updateResponsavel = new Chamado(17, "Tipo Exemplo", setor, uControle.getUsuarioById(7), uControle.getUsuarioById(5), urgencia);
        Chamado updateStatus = new Chamado(17, "Em atendimento", setor, uControle.getUsuarioById(7), uControle.getUsuarioById(5));
        Chamado updateAll = new Chamado(17, "Pausado", "Tipo Atualizado", "Título Atualizado", "Descrição Atualizada", setor, uControle.getUsuarioById(7), uControle.getUsuarioById(5), LocalDate.of(2023, 06, 18), null, urgencia, LocalDate.of(2023, 06, 18).plusDays(urgencia.getDias()));
        Chamado chamadoDelete = cControle.getChamadoById(17);

        // CHAMADOS: MÉTODOS

        // cControle.createChamado(chamadoCreate); // status, titulo, descricao, id_usuario, data_abertura

        // cControle.updateTriagemChamado(updateTriagem); // luciana.oliveira@example.com - senha345

        // cControle.updateResponsavelChamado(updateResponsavel); // id_responsavel marcos.ferreira@example.com - senha777

        // cControle.updateStatus(updateStatus); // status

        // cControle.updateAllChamado(updateAll); // rafaela.santos@example.com - senha456

        // cControle.deleteChamado(chamadoDelete); // rafaela.santos@example.com - senha456

        // System.out.println(cControle.getChamadoJsonById(10));

        // System.out.println(cControle.retriveAllChamados());

        // System.out.println(cControle.retriveChamadosForTriagem()); // status = 'pendente' e id_setor NULL

        // System.out.println(cControle.retriveChamadosByResponsaveleStatus(uControle.getUsuarioById(8), "Aberto"));

        // System.out.println(cControle.retriveChamadosByStatus("Fechado"));

        // System.out.println(cControle.retriveChamadosBySetor(setor));

        // System.out.println(cControle.retriveChamadosByTipo("Tipo 1"));

        // System.out.println(cControle.retriveChamadosByUsuario(uControle.getUsuarioById(8)));

        // System.out.println(cControle.retriveChamadosByResponsavel(uControle.getUsuarioById(9)));

        // System.out.println(cControle.getCountChamados());

        // System.out.println(cControle.getCountChamadosBySetor());

        // System.out.println(cControle.getCountChamadosByTipo());

        // System.out.println(cControle.getCountChamadosByStatus());
        
    }
}
