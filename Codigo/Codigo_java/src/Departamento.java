public class Departamento {
    // Atributos
    private int id;
    private String nome;
    private String localizacao;
    private int gerenteId;

    //Método construtor

    Departamento(int id, String nome, String localizacao, int gerenteId){
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.gerenteId = gerenteId;
    }
    
}
