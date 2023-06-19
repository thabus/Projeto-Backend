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

    public Cargo getCargoById(int id) {
        return this.cargoDAO.getById(id);
    }

    public boolean verificaAdminByLogin() {
        String cargoNome = "";

        Cargo cargo = this.cargoDAO.getCargoByUsuario(this.leitora.lerUsuario());

        if (cargo != null) {
            cargoNome = cargo.getNome();
        } 

        return cargoNome.equals("Administrador Sistema");
    }

    public boolean verificaTriagemByLogin() {
        String cargoNome = "";

        Cargo cargo = this.cargoDAO.getCargoByUsuario(this.leitora.lerUsuario());

        if (cargo != null) {
            cargoNome = cargo.getNome();
        } 

        return cargoNome.equals("Analista TI") | cargoNome.equals("Administrador Sistema");
    }

    public Cargo getCargobyUsuario() {

        Cargo cargo = this.cargoDAO.getCargoByUsuario(this.leitora.lerUsuario());

        return cargo;
    }
    
}
