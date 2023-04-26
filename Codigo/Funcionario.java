public class Funcionario extends Pessoa{
    private int id;

    Funcionario(int id, String nome, String sobrenome, String email, String telefone, String cpf){
        super(nome, sobrenome, email, telefone, cpf);
        this.id = id;
    }


    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }



}
