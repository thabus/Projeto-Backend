package model;
public class Cargo {

    private String nome;
    private Setor idSetor;

    public Cargo(String nome, Setor idSetor) {
        this.nome = nome;
        this.idSetor = idSetor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor getIdSetor() {
        return this.idSetor;
    }

    public void setIdSetor(Setor idSetor) {
        this.idSetor = idSetor;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", idSetor='" + getIdSetor() + "'" +
            "}";
    }

}
