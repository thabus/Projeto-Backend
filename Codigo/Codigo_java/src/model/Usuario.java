package model;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private Cargo cargo;
    private Setor setor;
    private String telefone;
    ArrayList<Chamado> chamados = new ArrayList<>();

    public Usuario(int id, String nome, String email, String senha, Cargo cargo, Setor setor, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.setor = setor;
        this.telefone = telefone;

    }

    public Usuario(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;

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

    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Setor getSetor() {
        return this.setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", senha='" + getSenha() + "'" +
            ", cargo='" + getCargo() + "'" +
            ", setor='" + getSetor() + "'" +
            ", telefone='" + getTelefone() + "'" +
            "}";
    }


}