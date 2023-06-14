package controler;

import java.sql.Connection;

import dao.CargoDAO;
import dao.ConnectionFactory;
import model.Cargo;
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

        Cargo cargo = this.cargoDAO.getCargoByLogin(email, senha);

        if (cargo != null) {
            cargoNome = cargo.getNome();
        } 

        return cargoNome.equals("Administrador Sistema");
    }
    
}
