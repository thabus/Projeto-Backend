package utils;

import java.util.Scanner;

public class LeitoraDados {
    private Scanner scanner;

    public LeitoraDados() {
        this.scanner = new Scanner(System.in);
    }

    public String lerTexto() {
        return scanner.nextLine();
    }

}
