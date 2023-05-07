public class Usuario {
    private int id;
    private String login;
    private String senha;
    private int idCliente;
    private int idFuncinario;

    public Usuario(int id, String login, String senha, int idCliente, int idFuncinario) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.idCliente = idCliente;
        this.idFuncinario = idFuncinario;
    }

    public Usuario(String login, String senha, int idCliente, int idFuncinario) {
        this.login = login;
        this.senha = senha;
        this.idCliente = idCliente;
        this.idFuncinario = idFuncinario;
    }

    public void readUsuario(Usuario usuario) {
        System.out.println(usuario);
    }

    public void updateUsuario(int id, String login, String senha, int idCliente, int idFuncinario) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.idCliente = idCliente;
        this.idFuncinario = idFuncinario;
    }

    @Override
    public String toString() {
        return
            " Id: " + getId() + "\n" +
            "Login: " + getLogin() + "\n" +
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

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
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