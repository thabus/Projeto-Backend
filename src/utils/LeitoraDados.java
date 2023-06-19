package utils;

import java.util.Scanner;

import model.Usuario;

public class LeitoraDados {
    private Scanner scanner;

    public LeitoraDados() {
        this.scanner = new Scanner(System.in);
    }

    public String lerTexto() {
        return scanner.nextLine();
    }

    public Usuario lerUsuario() {

        System.out.print("Insira seu email: ");
        String email = this.lerTexto();

        System.out.print("Insira sua senha: ");
        String senha = this.lerTexto();

        Usuario usuario = new Usuario(email, senha);

        return usuario;
    }

}
