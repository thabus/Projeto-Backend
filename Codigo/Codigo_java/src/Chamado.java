import javax.xml.crypto.Data;

public class Chamado {
    private int protocolo;
    private String status;
    private int idSetor;
    private String tipo;
    private String titulo;
    private String descricao;
    private int idUsuario;
    private String nomeSolicitante;
    private String emailSolicitante;
    private String telefoneSolicitante;
    private int idResponsavel;
    private Data dataAbertura;
    private Data dataFechamento;
    private Data prazo;
    private Data dataPrazo;
    private int urgencia;

    public Chamado(int protocolo, String status, int idSetor, String tipo, String titulo, String descricao, int idUsuario, String nomeSolicitante, String emailSolicitante, String telefoneSolicitante, int idResponsavel, Data dataAbertura, Data dataFechamento, Data prazo, Data dataPrazo, int urgencia) {
        this.protocolo = protocolo;
        this.status = status;
        this.idSetor = idSetor;
        this.tipo = tipo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.idUsuario = idUsuario;
        this.nomeSolicitante = nomeSolicitante;
        this.emailSolicitante = emailSolicitante;
        this.telefoneSolicitante = telefoneSolicitante;
        this.idResponsavel = idResponsavel;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.prazo = prazo;
        this.dataPrazo = dataPrazo;
        this.urgencia = urgencia;
    }

    public int getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdSetor() {
        return this.idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeSolicitante() {
        return this.nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getEmailSolicitante() {
        return this.emailSolicitante;
    }

    public void setEmailSolicitante(String emailSolicitante) {
        this.emailSolicitante = emailSolicitante;
    }

    public String getTelefoneSolicitante() {
        return this.telefoneSolicitante;
    }

    public void setTelefoneSolicitante(String telefoneSolicitante) {
        this.telefoneSolicitante = telefoneSolicitante;
    }

    public int getIdResponsavel() {
        return this.idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public Data getDataAbertura() {
        return this.dataAbertura;
    }

    public void setDataAbertura(Data dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Data getDataFechamento() {
        return this.dataFechamento;
    }

    public void setDataFechamento(Data dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Data getPrazo() {
        return this.prazo;
    }

    public void setPrazo(Data prazo) {
        this.prazo = prazo;
    }

    public Data getDataPrazo() {
        return this.dataPrazo;
    }

    public void setDataPrazo(Data dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public int getUrgencia() {
        return this.urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    @Override
    public String toString() {
        return "{" +
            " protocolo='" + getProtocolo() + "'" +
            ", status='" + getStatus() + "'" +
            ", idSetor='" + getIdSetor() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", idUsuario='" + getIdUsuario() + "'" +
            ", nomeSolicitante='" + getNomeSolicitante() + "'" +
            ", emailSolicitante='" + getEmailSolicitante() + "'" +
            ", telefoneSolicitante='" + getTelefoneSolicitante() + "'" +
            ", idResponsavel='" + getIdResponsavel() + "'" +
            ", dataAbertura='" + getDataAbertura() + "'" +
            ", dataFechamento='" + getDataFechamento() + "'" +
            ", prazo='" + getPrazo() + "'" +
            ", dataPrazo='" + getDataPrazo() + "'" +
            ", urgencia='" + getUrgencia() + "'" +
            "}";
    }

}
