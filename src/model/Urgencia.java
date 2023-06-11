package model;

import java.io.Serializable;

public class Urgencia implements Serializable {

    private int escala;
    private int dias;

    public Urgencia(int escala, int dias) {
        this.escala = escala;
        this.dias = dias;
    }

    public int getEscala() {
        return this.escala;
    }

    public void setEscala(int escala) {
        this.escala = escala;
    }

    public int getDias() {
        return this.dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "{" +
            " escala='" + getEscala() + "'" +
            ", dias='" + getDias() + "'" +
            "}";
    }
}
