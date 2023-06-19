package model;
import java.time.LocalDate;

public class Chamado {

    private int id;
    private String status;
    private String tipo;
    private String titulo;
    private String descricao;
    private Setor setorID;
    private Usuario usuarioID;
    private Usuario responsavelID;
    private LocalDate dataAbertura;
    private LocalDate dataFechamento;
    private Urgencia urgencia;
    private LocalDate prazo;
    
    public Chamado(int id, String status, String tipo, String titulo, String descricao, Setor setorID, Usuario usuarioID, Usuario responsavelID, LocalDate dataAbertura, LocalDate dataFechamento, Urgencia urgencia, LocalDate prazo) {
        this.id = id;
        this.status = status;
        this.tipo = tipo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.setorID = setorID;
        this.usuarioID = usuarioID;
        this.responsavelID = responsavelID;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.urgencia = urgencia;
        this.prazo = prazo;
    }

    public Chamado(int id, String status, String titulo, String descricao, Usuario usuarioID, LocalDate dataAbertura) {
        this.id = id;
        this.status = status;
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuarioID = usuarioID;
        this.dataAbertura = dataAbertura;
    }

    public Chamado(int id, String tipo, Setor setorID, Usuario usuarioID, Usuario responsavelID, Urgencia urgencia) {
        this.id = id;
        this.tipo = tipo;
        this.setorID = setorID;
        this.usuarioID = usuarioID;
        this.responsavelID = responsavelID;
        this.urgencia = urgencia;
    }

    public Chamado(int id, String status, Setor setorID, Usuario usuarioID, Usuario responsavelID) {
        this.id = id;
        this.status = status;
        this.setorID = setorID;
        this.usuarioID = usuarioID;
        this.responsavelID = responsavelID;
    }

    public Chamado(int id, String tipo, Setor setorID, Urgencia urgencia) {
        this.id = id;
        this.tipo = tipo;
        this.setorID = setorID;
        this.urgencia = urgencia;
    }

    public Chamado(int id, Usuario responsavelID) {
        this.id = id;
        this.responsavelID = responsavelID;
    }

    public Chamado(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Setor getSetorID() {
        return this.setorID;
    }

    public void setSetorID(Setor setorID) {
        this.setorID = setorID;
    }

    public Usuario getUsuarioID() {
        return this.usuarioID;
    }

    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Usuario getResponsavelID() {
        return this.responsavelID;
    }

    public void setResponsavelID(Usuario responsavelID) {
        this.responsavelID = responsavelID;
    }

    public LocalDate getDataAbertura() {
        return this.dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return this.dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Urgencia getUrgencia() {
        return this.urgencia;
    }

    public void setUrgencia(Urgencia urgencia) {
        this.urgencia = urgencia;
    }

    public LocalDate getPrazo() {
        return this.prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", status='" + getStatus() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", idSetor='" + getSetorID().getId() + "'" +
            ", idUsuario='" + getUsuarioID().getId() + "'" +
            ", idResponsavel='" + getResponsavelID().getId() + "'" +
            ", dataAbertura='" + getDataAbertura() + "'" +
            ", dataFechamento='" + getDataFechamento() + "'" +
            ", urgencia='" + getUrgencia().getDias() + "'" +
            ", prazo='" + getPrazo() + "'" +
            "}";
    }

}
