package controler;

import dao.ChamadoDAO;
import dao.ConnectionFactory;
import model.Chamado;
import utils.LeitoraDados;

import java.sql.Connection;
import java.util.ArrayList;

public class ChamadoControle {
    
    private ChamadoDAO chamadoDAO;
    private Connection connection;
    private ConnectionFactory fabricaDeConexao;
    private LeitoraDados leitora;

    public ChamadoControle() {
        this.fabricaDeConexao = new ConnectionFactory();
        this.connection = fabricaDeConexao.recuperarConexao();
        this.chamadoDAO = new ChamadoDAO(connection);
        this.leitora = new LeitoraDados();
    }

    public void createChamado(Chamado chamado) {
        this.chamadoDAO.create(chamado);
    }

    public void deleteChamado(Chamado chamado) {
        this.chamadoDAO.delete(chamado);
    }

    public Chamado getChamadoById(int id) {
        return this.chamadoDAO.getById(id);
    }

    public ArrayList<Chamado> retriveAllChamados() {
        return this.chamadoDAO.retriveAll();
    }

    public void updateAllChamado(Chamado chamado) {
        this.chamadoDAO.updateAll(chamado);
    }

    public void updateTriagemChamado(Chamado chamado) {
        this.chamadoDAO.updateTriagem(chamado);
    }

    public void updateResponsavelChamado(Chamado chamado) {
        this.chamadoDAO.updateResponsavel(chamado);
    }

    public void updateStatus(Chamado chamado) {
        this.chamadoDAO.updateStatus(chamado);
    }

}


