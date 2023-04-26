public class Cliente extends Pessoa {
    private int id;
    private String cnpj;

    Cliente(int id, String nome, String sobrenome, String email, String telefone, String cpf, String cnpj){
        super(nome, sobrenome, email, telefone, cpf);
        this.id = id;
        this.cnpj = cnpj;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCnpj(){
        
    }
}
