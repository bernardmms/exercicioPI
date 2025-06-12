package org.example;


public class Escolaridade {
    private String nivel_escolar;

    public Escolaridade ( String nivel_escolar) {
        this.setNivel_escolar(nivel_escolar);
    }

    public String getNivel_escolar() {
        return this.nivel_escolar;
    }

    public void setNivel_escolar(String nivel_escolar) {
        if (nivel_escolar == null) {
            throw new IllegalArgumentException("Nivel de escolaridade não pode ser nulo");
        }
        this.nivel_escolar = nivel_escolar;
    }
}
