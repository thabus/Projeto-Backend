public class Usuario {
    private int id;
    private String email;
    private String senha;
    private int idCliente;
    private int idFuncinario;

    public Usuario(int id, String email, String senha, int idCliente, int idFuncinario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.idCliente = idCliente;
        this.idFuncinario = idFuncinario;
    }

    public Usuario(String email, String senha, int idCliente, int idFuncinario) {
        this.email = email;
        this.senha = senha;
        this.idCliente = idCliente;
        this.idFuncinario = idFuncinario;
    }

    public void readUsuario(Usuario usuario) {
        System.out.println(usuario);
    }

    public void updateUsuario(int id, String email, String senha, int idCliente, int idFuncinario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.idCliente = idCliente;
        this.idFuncinario = idFuncinario;
    }

    @Override
    public String toString() {
        return
            " Id: " + getId() + "\n" +
            "Login: " + getEmail() + "\n" +
            "Senha: " + getSenha() + "\n" +
            "idCliente: " + getIdCliente() + "\n" +
            "idFuncinario: "  + getIdFuncinario()
            ;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setLogin(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncinario() {
        return this.idFuncinario;
    }

    public void setIdFuncinario(int idFuncinario) {
        this.idFuncinario = idFuncinario;
    }


}