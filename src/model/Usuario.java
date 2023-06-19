package model;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private Cargo cargoID;
    private String telefone;
    private ArrayList<Chamado> chamados = new ArrayList<>();

    public Usuario(int id, String nome, String email, String senha, Cargo cargoID, String telefone, ArrayList<Chamado> chamados) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargoID = cargoID;
        this.telefone = telefone;
        this.chamados = chamados;
    }

    public Usuario(int id, String nome, String email, String senha, Cargo cargoID, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargoID = cargoID;
        this.telefone = telefone;
    }

    public Usuario(String nome, String email, String senha, Cargo cargoID, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargoID = cargoID;
        this.telefone = telefone;
    }

    public Usuario(int id, String nome, String email, String senha, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public Usuario(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(Cargo cargoID) {
        this.cargoID = cargoID;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cargo getCargoID() {
        return this.cargoID;
    }

    public void setCargoID(Cargo cargoID) {
        this.cargoID = cargoID;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(ArrayList<Chamado> chamados) {
        this.chamados = chamados;
    }

    public void addChamado(Chamado chamado) {
        this.chamados.add(chamado);
    }

    public void removeChamado(Chamado chamado) {
        this.chamados.remove(chamado);
    }

    public Cargo getCargo() {
        return cargoID;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", senha='" + getSenha() + "'" +
            ", cargo='" + getCargoID().getId() + "'" +
            ", telefone='" + getTelefone() + "'" +
            "}";
    }
}