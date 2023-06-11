package model;

import java.io.Serializable;

public class Cargo implements Serializable{

    private int id;
    private String nome;
    private Setor setorID;

    public Cargo(int id, String nome, Setor setorID) {
        this.id = id;
        this.nome = nome;
        this.setorID = setorID;
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

    public Setor getSetorID() {
        return this.setorID;
    }

    public void setSetorID(Setor setorID) {
        this.setorID = setorID;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId()+ "'" +
            " nome='" + getNome() + "'" +
            ", setorID='" + getSetorID() + "'" +
            "}";
    }
}
