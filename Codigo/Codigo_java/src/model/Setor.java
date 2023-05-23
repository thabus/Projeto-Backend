package model;
public class Setor {
    private int id;
    private String nome;
    private String localizacao;
    private Usuario gerente;

    public Setor(int id, String nome, String localizacao, Usuario gerente) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return
            "Id: " + getId() + "\n" +
            "Nome: " + getNome() + "\n" +
            "Localização: " + getLocalizacao() + "\n" +
            "Gerente: " + getGerente()
            ;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Usuario getGerente() {
        return this.gerente;
    }

    public void setGerente(Usuario gerente) {
        this.gerente = gerente;
    }

}
