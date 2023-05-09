public class Cargo {

    private String nome;
    private int idSetor;

    public Cargo(String nome, int idSetor) {
        this.nome = nome;
        this.idSetor = idSetor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdSetor() {
        return this.idSetor;
    }

    public void setIdSetor(int idSetor) {
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
