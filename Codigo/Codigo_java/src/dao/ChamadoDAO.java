package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Chamado;

public class ChamadoDAO {

    public boolean create(Chamado chamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "INSERT INTO chamado (protocolo, status, titulo, descricao, id_usuario, nome_solicitante, email_solicitante, telefone_solicitante, data_abertura) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1, chamado.getProtocolo());
            pstm.setString(2, chamado.getStatus());
            pstm.setString(3, chamado.getTitulo());
            pstm.setString(4, chamado.getDescricao());
            pstm.setInt(5, chamado.getIdUsuario());
            pstm.setString(6, chamado.getNomeSolicitante());
            pstm.setString(7, chamado.getEmailSolicitante());
            pstm.setString(8, chamado.getTelefoneSolicitante());
            pstm.setObject(9, chamado.getDataAbertura());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean delete(Chamado chamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "DELETE FROM chamado WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1, chamado.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public Chamado getByProtocolo(int protocolo) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        String sql = "SELECT * FROM chamado WHERE protocolo = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(1, protocolo);
            ResultSet rst = pstm.executeQuery();
            Chamado chamado = null;
            if (rst.next()) {
                chamado = new Chamado(rst.getInt("protocolo"), rst.getString("status"), rst.getInt("id_setor"), rst.getString("tipo"),rst.getString("titulo"), rst.getString("descricao"), rst.getInt("id_usuario"), rst.getString("nome_solicitante"), rst.getString("email_solicitante"), rst.getString("telefone_solicitante"), rst.getInt("id_responsavel"), rst.getObject("data_abertura", LocalDate.class), rst.getObject("data_fechamento", LocalDate.class), rst.getObject("prazo", LocalDate.class), rst.getObject("data_prazo", LocalDate.class), rst.getInt("urgencia"));
            }
            connection.close();

            return chamado;
        }
    }

    public ArrayList<Chamado> retriveAll() throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        String sql = "SELECT * FROM chamado";

        stm.execute(sql);
        ResultSet rst = stm.getResultSet();
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        while (rst.next()){
            int protocolo = rst.getInt("protocolo");
            String status = rst.getString("status");
            int idSetor = rst.getInt("id_setor");
            String tipo = rst.getString("tipo");
            String titulo = rst.getString("titulo");
            String descricao = rst.getString("descricao");
            int idUsuario = rst.getInt("id_usuario");
            String nomeSolicitante = rst.getString("nome_solicitante");
            String emailSolicitante = rst.getString("email_solicitante");
            String telefoneSolicitante = rst.getString("telefone_solicitante");
            int idResponsavel = rst.getInt("id_responsavel");
            LocalDate dataAbertura = rst.getObject("data_abertura", LocalDate.class);
            LocalDate dataFechamento = rst.getObject("data_fechamento", LocalDate.class);
            LocalDate prazo = rst.getObject("prazo", LocalDate.class);
            LocalDate dataPrazo = rst.getObject("data_prazo", LocalDate.class);
            int urgencia = rst.getInt("urgencia");

            Chamado c = new Chamado(protocolo, status, idSetor, tipo, titulo, descricao, idUsuario, nomeSolicitante, emailSolicitante, telefoneSolicitante, idResponsavel, dataAbertura, dataFechamento, prazo, dataPrazo, urgencia);
            chamados.add(c);
        }
        connection.close();

        return chamados;
    }

    public boolean updateAll(Chamado chamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE chamado SET status = ?, id_setor = ?, tipo = ?, titulo = ?, descricao = ?, id_usuario = ?, nome_solictante = ?, email_solicitante = ?, telefone_solictante = ?, id_responsavel = ?, data_abertura = ?, data_fechamento = ?, urgencia = ?, prazo = ?, data_prazo = ? WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

            pstm.setString(1, chamado.getStatus());
            pstm.setInt(2, chamado.getIdSetor());
            pstm.setString(3, chamado.getTipo());
            pstm.setString(4, chamado.getTitulo());
            pstm.setString(5, chamado.getDescricao());
            pstm.setInt(6, chamado.getIdUsuario());
            pstm.setString(7, chamado.getNomeSolicitante());
            pstm.setString(8, chamado.getEmailSolicitante());
            pstm.setString(9, chamado.getTelefoneSolicitante());
            pstm.setInt(10, chamado.getIdResponsavel());
            pstm.setObject(11, chamado.getDataAbertura());
            pstm.setObject(12, chamado.getDataFechamento());
            pstm.setInt(13, chamado.getUrgencia());
            pstm.setObject(14, chamado.getPrazo());
            pstm.setObject(15, chamado.getDataPrazo());
            pstm.setInt(16, chamado.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean updateStatus(Chamado chamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE chamado SET status = ? WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

            pstm.setString(1, chamado.getStatus());
            pstm.setInt(2, chamado.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean updateResponsavel(Chamado chamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE chamado id_responsavel = ? WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

            pstm.setInt(1, chamado.getIdResponsavel());
            pstm.setInt(2, chamado.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }

    public boolean updateTriagem(Chamado chamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        boolean sucesso = false;

        String sql = "UPDATE chamado SET id_setor = ?, tipo = ?, urgencia = ? WHERE protocolo = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

            pstm.setInt(1, chamado.getIdSetor());
            pstm.setString(2, chamado.getTipo());
            pstm.setInt(3, chamado.getUrgencia());
            pstm.setInt(4, chamado.getProtocolo());

            sucesso = pstm.execute();
            connection.close();
            return sucesso;
        }
    }
}


