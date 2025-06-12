package org.example;

public class Cidade {
    private String nome;
    private Estado estado;

    public Cidade(String nome, Estado estado) {
        this.setNome(nome);
        this.setEstado(estado);
    }

    public String getNomeEstado() {
        if (this.estado == null) {
            return "Estado não informado";
        }
        return this.estado.getNome();
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("A cidade deve pertencer a um estado.");
        }
        this.estado = estado;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("A cidade não pode ser nula");
        }
        this.nome = nome;
    }
}