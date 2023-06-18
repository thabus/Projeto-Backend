package controler;

import java.sql.Connection;

import dao.CargoDAO;
import dao.ConnectionFactory;
import model.Cargo;
import model.Usuario;
import utils.LeitoraDados;

public class CargoControle {

    private CargoDAO cargoDAO;
    private Connection connection;
    private ConnectionFactory fabricaDeConexao;
    private LeitoraDados leitora;

    public CargoControle() {
        this.fabricaDeConexao = new ConnectionFactory();
        this.connection = fabricaDeConexao.recuperarConexao();
        this.cargoDAO = new CargoDAO(connection);
        this.leitora = new LeitoraDados();
    }

    public boolean verificaAdminByLogin() {
        String cargoNome = "";

        System.out.print("Insira seu email: ");
        String email = this.leitora.lerTexto();

        System.out.print("Insira sua senha: ");
        String senha = this.leitora.lerTexto();

        Usuario usuario = new Usuario(email, senha);

        Cargo cargo = this.cargoDAO.getCargoByUsuario(usuario);

        if (cargo != null) {
            cargoNome = cargo.getNome();
        } 

        return cargoNome.equals("Administrador Sistema");
    }

    public boolean verificaTriagemByLogin() {
        String cargoNome = "";

        System.out.print("Insira seu email: ");
        String email = this.leitora.lerTexto();

        System.out.print("Insira sua senha: ");
        String senha = this.leitora.lerTexto();

        Usuario usuario = new Usuario(email, senha);

        Cargo cargo = this.cargoDAO.getCargoByUsuario(usuario);

        if (cargo != null) {
            cargoNome = cargo.getNome();
        } 

        return cargoNome.equals("Analista TI") | cargoNome.equals("Administrador Sistema");
    }

    public Cargo getCargobyUsuario() {

        System.out.print("Insira seu email: ");
        String email = this.leitora.lerTexto();

        System.out.print("Insira sua senha: ");
        String senha = this.leitora.lerTexto();

        Usuario usuario = new Usuario(email, senha);

        Cargo cargo = this.cargoDAO.getCargoByUsuario(usuario);

        return cargo;
    }
    
}
