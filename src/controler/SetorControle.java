package controler;

import java.sql.Connection;

import dao.SetorDAO;
import dao.ConnectionFactory;
import model.Setor;

public class SetorControle {

    private SetorDAO setorDAO;
    private Connection connection;
    private ConnectionFactory fabricaDeConexao;

    public SetorControle() {
        this.fabricaDeConexao = new ConnectionFactory();
        this.connection = fabricaDeConexao.recuperarConexao();
        this.setorDAO = new SetorDAO(connection);
    }

    public Setor getSetorById(int id) {
        return this.setorDAO.getById(id);
    }
}