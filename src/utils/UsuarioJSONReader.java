package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.Chamado;
import model.Usuario;

public class UsuarioJSONReader {

    public static final String JSON_FILE = "usuario.txt";

    public static void main(String[] args) {
        
        Gson gson = new Gson();

        Usuario usuario1 = new Usuario(25, "Vitor Lobianco", "vitor.lobi@example.com", "senha123", "99247-1219");
        Chamado chamado1 = new Chamado(20, "Pendente", "Exemplo JSON", "Descrição JSON", usuario1, LocalDate.of(2022, 06, 11));
        usuario1.addChamado(chamado1);

        // JsonObject chamadoJson = new JsonObject();
        // chamadoJson.addProperty("id", chamado1.getId());
        // chamadoJson.addProperty("status", chamado1.getStatus());
        // chamadoJson.addProperty("titulo", chamado1.getTitulo());
        // chamadoJson.addProperty("descricao", chamado1.getDescricao());
        // chamadoJson.addProperty("usuario_id", gson.toJson(chamado1.getUsuarioID().getId()));
        // chamadoJson.addProperty("data_abertura", chamado1.getDataAbertura().format(DateTimeFormatter.ISO_LOCAL_DATE));

        // String jsonC = gson.toJson(chamadoJson);

        // System.out.println(jsonC);

        String json = usuarioJSON(usuario1, gson);
        System.out.println(json);

        
        
    }

    public static String usuarioJSON(Usuario usuario, Gson gson) {
        JsonObject usuarioJson = new JsonObject();
        usuarioJson.addProperty("id", usuario.getId());
        usuarioJson.addProperty("nome", usuario.getNome());
        usuarioJson.addProperty("email", usuario.getEmail());
        usuarioJson.addProperty("senha", usuario.getSenha());
        usuarioJson.addProperty("telefone", usuario.getTelefone());

        String jsonU = gson.toJson(usuarioJson);
        return jsonU;

    }
}
