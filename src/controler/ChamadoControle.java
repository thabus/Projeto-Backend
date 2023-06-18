package controler;

import dao.ChamadoDAO;
import dao.ConnectionFactory;
import model.Chamado;
//import utils.LeitoraDados;
import model.Setor;
import model.Usuario;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

public class ChamadoControle {
    
    private ChamadoDAO chamadoDAO;
    private Connection connection;
    private ConnectionFactory fabricaDeConexao;
    private CargoControle cargoControle;

    public ChamadoControle() {
        this.fabricaDeConexao = new ConnectionFactory();
        this.connection = fabricaDeConexao.recuperarConexao();
        this.chamadoDAO = new ChamadoDAO(connection);
        this.cargoControle = new CargoControle();
    }

    public void createChamado(Chamado chamado) {
        this.chamadoDAO.create(chamado);
    }

    public void deleteChamado(Chamado chamado) {
        if (cargoControle.verificaAdminByLogin()) {
            this.chamadoDAO.delete(chamado);
        } else {
            System.out.println("Não possui permissão para deletar um chamado.");
        }
    }

    public Chamado getChamadoById(int id) {
        return this.chamadoDAO.getById(id);
    }

    public ArrayList<Chamado> retriveAllChamados() {
        return this.chamadoDAO.retriveAll();
    }

    public void updateAllChamado(Chamado chamado) {
        if (cargoControle.verificaAdminByLogin()) {
            this.chamadoDAO.updateAll(chamado);
        } else {
            System.out.println("Não possui permissão para atualizar todo o chamado.");
        }
    }

    public void updateTriagemChamado(Chamado chamado) {
        if (cargoControle.verificaTriagemByLogin()) {
            this.chamadoDAO.updateTriagem(chamado);
        } else {
            System.out.println("Não possui permissão para triagem de chamados.");
        }
    }

    public void updateResponsavelChamado(Chamado chamado) {
        
        int usuarioSetorID = cargoControle.getCargobyUsuario().getSetorID().getId();
        int chamadoSetorID = chamado.getSetorID().getId();

        if (usuarioSetorID == chamadoSetorID && chamado.getUsuarioID().getId() != chamado.getResponsavelID().getId()) {
           this.chamadoDAO.updateResponsavel(chamado); 
        } else {
            System.out.println("Não foi possível assumir esse chamado.");
        }
    }

    public void updateStatus(Chamado chamado) {

        int usuarioSetorID = cargoControle.getCargobyUsuario().getSetorID().getId();
        int chamadoSetorID = chamado.getSetorID().getId();

        if (usuarioSetorID == chamadoSetorID) {
           this.chamadoDAO.updateStatus(chamado);
        } else {
            System.out.println("Não foi possível mudar o status desse chamado.");
        }
    }

    public ArrayList<Chamado> retriveChamadosForTriagem() {
        return this.chamadoDAO.retriveForTriagem();
    }

    public ArrayList<Chamado> retriveChamadosByResponsaveleStatus(Usuario responsavel, String status) {
        return this.chamadoDAO.retriveByResponsaveleStatus(responsavel, status);
    }

    public ArrayList<Chamado> retriveChamadosByStatus(String status) {
        return this.chamadoDAO.retriveByStatus(status);
    }

    public ArrayList<Chamado> retriveChamadosBySetor(Setor setor) {
        return this.chamadoDAO.retriveBySetor(setor);
    }

    public ArrayList<Chamado> retriveChamadosByTipo(String tipo) {
        return this.chamadoDAO.retriveByTipo(tipo);
    }

    public ArrayList<Chamado> retriveChamadosByUsuario(Usuario usuario) {
        return this.chamadoDAO.retriveByUsuario(usuario);
    }

    public ArrayList<Chamado> retriveChamadosByResponsavel(Usuario responsavel) {
        return this.chamadoDAO.retriveByResponsavel(responsavel);
    }

    public int getCountChamados() {
        return this.chamadoDAO.getCount();
    }

    public Map<Setor, Integer> getCountChamadosBySetor() {
        return this.chamadoDAO.getCountBySetor();
    }

    public Map<String, Integer> getCountChamadosByTipo() {
        return this.chamadoDAO.getCountByTipo();
    }

    public Map<String, Integer> getCountChamadosByStatus() {
        return this.chamadoDAO.getCountByStatus();
    }

}


