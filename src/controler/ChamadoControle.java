package controler;

import dao.ChamadoDAO;
import dao.ConnectionFactory;
import model.Chamado;
import model.Setor;
import model.Usuario;
import utils.LocalDateAdapter;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ChamadoControle {
    
    private ChamadoDAO chamadoDAO;
    private Connection connection;
    private ConnectionFactory fabricaDeConexao;
    private CargoControle cargoControle;
    private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();

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

    public String getChamadoJsonById(int id) {
        return gson.toJson(this.chamadoDAO.getById(id));
    }

    public Chamado getChamadoById(int id) {
        return this.chamadoDAO.getById(id);
    }

    public String retriveAllChamados() {
        return gson.toJson(this.chamadoDAO.retriveAll());
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

    public String retriveChamadosForTriagem() {
        return gson.toJson(this.chamadoDAO.retriveForTriagem());
    }

    public String retriveChamadosByResponsaveleStatus(Usuario responsavel, String status) {
        return gson.toJson(this.chamadoDAO.retriveByResponsaveleStatus(responsavel, status));
    }

    public String retriveChamadosByStatus(String status) {
        return gson.toJson(this.chamadoDAO.retriveByStatus(status));
    }

    public String retriveChamadosBySetor(Setor setor) {
        return gson.toJson(this.chamadoDAO.retriveBySetor(setor));
    }

    public String retriveChamadosByTipo(String tipo) {
        return gson.toJson(this.chamadoDAO.retriveByTipo(tipo));
    }

    public String retriveChamadosByUsuario(Usuario usuario) {
        return gson.toJson(this.chamadoDAO.retriveByUsuario(usuario));
    }

    public String retriveChamadosByResponsavel(Usuario responsavel) {
        return gson.toJson(this.chamadoDAO.retriveByResponsavel(responsavel));
    }

    public String getCountChamados() {
        return gson.toJson(this.chamadoDAO.getCount());
    }

    public String getCountChamadosBySetor() {
        Map<Setor, Integer> countSetor = chamadoDAO.getCountBySetor();

        Map<String, Integer> countSetorJson = new HashMap<>();
        for (Map.Entry<Setor, Integer> entry : countSetor.entrySet()) {
            Setor setor = entry.getKey();
            int count = entry.getValue();
            countSetorJson.put(setor.getNome(), count);
        }
        return gson.toJson(countSetorJson);
    }

    public String getCountChamadosByTipo() {
        return gson.toJson(this.chamadoDAO.getCountByTipo());
    }

    public String getCountChamadosByStatus() {
        return gson.toJson(this.chamadoDAO.getCountByStatus());
    }

}


