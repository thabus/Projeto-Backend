package controler;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.ConnectionFactory;
import dao.UsuarioDAO;
import model.Usuario;
import utils.LocalDateAdapter;

public class UsuarioControle {

    private UsuarioDAO usuarioDAO;
    private Connection connection;
    private ConnectionFactory fabricaDeConexao;
    private CargoControle cargoControle;
    ArrayList<String> usuariosEmail;
    private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();

    public UsuarioControle() {
        this.fabricaDeConexao = new ConnectionFactory();
        this.cargoControle = new CargoControle();
        this.connection = fabricaDeConexao.recuperarConexao();
        this.usuarioDAO = new UsuarioDAO(connection);
    }

    public void createUsuario(Usuario usuario) {
        if (verificaEmail(usuario)) {
            if (cargoControle.verificaAdminByLogin()) {
            this.usuarioDAO.create(usuario);
            } else {
                System.out.println("Não possui permissão para criar um usuário");
            }
        } else {
            System.out.println("E-mail já cadastrado.");
        } 
    }

    public void deleteUsuario(Usuario usuario) {
        if (cargoControle.verificaAdminByLogin()) {
            this.usuarioDAO.delete(usuario);
        } else {
            System.out.println("Não possui permissão para criar um usuário");
        }
    }

    public String getUsuarioJsonById(int id) {
        return gson.toJson(this.usuarioDAO.getById(id));
    }

    public Usuario getUsuarioById(int id) {
        return this.usuarioDAO.getById(id);
    }

    public String retriveAllUsuarios() {
        return gson.toJson(this.usuarioDAO.retriveAll());
    }

    public void updateAllUsuario(Usuario usuario) {
        if (verificaEmail(usuario)) {
            this.usuarioDAO.update(usuario);
        } else {
            System.out.println("E-mail já cadastrado.");
        }
    }

    public boolean verificaEmail(Usuario usuario) {
        usuariosEmail = new ArrayList<String>(usuarioDAO.retriveEmails());
        boolean contains = usuariosEmail.contains(usuario.getEmail());

        return !contains;
    }

}
