package model;

import java.io.Serializable;

public class Setor implements Serializable {
    private int id;
    private String nome;
    private Usuario gerenteID;

    public Setor(int id, String nome, Usuario gerenteID) {
        this.id = id;
        this.nome = nome;
        this.gerenteID = gerenteID;
    }

    public Setor(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Setor(int id){
        this.id = id;
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

    public Usuario getGerenteID() {
        return this.gerenteID;
    }

    public void setGerenteID(Usuario gerenteID) {
        this.gerenteID = gerenteID;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", gerenteID='" + getGerenteID() + "'" +
            "}";
    }

   
}
