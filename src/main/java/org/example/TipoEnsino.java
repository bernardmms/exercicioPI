package org.example;

public class TipoEnsino {
    private String nome;

    public TipoEnsino(String nome) {
        this.setNome(nome);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("O tipo de ensino não pode ser nulo");
        }
        this.nome = nome;
    }
}
