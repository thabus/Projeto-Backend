import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CargoDAO;
import dao.ChamadoDAO;
import dao.SetorDAO;
import dao.UsuarioDAO;
import model.Cargo;
import model.Chamado;
import model.Setor;
import model.Usuario;

public class Main {
    public static void main(String[] args) throws SQLException {
        testeCargoDAO();
    }

    public static void testeCargoDAO() throws SQLException {
        Cargo cargo1 = new Cargo("Analista", 2);
        Cargo cargo2 = new Cargo("Gerente", 2);
        Cargo cargo3 = new Cargo("Operações", 3);
        CargoDAO cdao = new CargoDAO();

        cdao.delete(cargo1);
        cdao.delete(cargo2);
        cdao.delete(cargo3);

        cdao.create(cargo1);
        cdao.create(cargo2);
        cdao.create(cargo3);

        cdao.update(cargo3);

        System.out.println(cdao.getByNome("Operações"));

        ArrayList<Cargo> cargos =  cdao.retriveAll();

        for (Cargo cargo : cargos) {
            System.out.println(cargo.getNome());
        }
    }

    public static void testeChamadoDAO() throws SQLException {
        Chamado chamado1 = new Chamado(1234, "aberto", "Troca de Fonte", "Meu computador queimou", 123445,"Amanda Senra", "amanda@gmail.com", "219121212131", new Date(2023, 08, 19));
        ChamadoDAO chamadao = new ChamadoDAO();

        chamadao.create(chamado1);
    }

    public static void testeUsuarioDAO() throws SQLException {
        Usuario usuario1 = new Usuario("Aline", "aline@gmail.com", "ali123", "21911111111");
        UsuarioDAO udao = new UsuarioDAO();

        udao.create(usuario1);
    }

    public static void testeSetorDAO() throws SQLException {
        Setor setor1 = new Setor(1, "Vitor", "TI", 12345);
        SetorDAO sdao = new SetorDAO();

        sdao.create(setor1);
    }
}
