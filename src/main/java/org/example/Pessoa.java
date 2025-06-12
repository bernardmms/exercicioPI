package org.example;

public class Pessoa {
    private String nome;
    private Escolaridade escolaridade;
    private Cidade naturalidade;

    public Pessoa(String nome, Escolaridade escolaridade, Cidade naturalidade) {
        this.setNome(nome);
        this.setEscolaridade(escolaridade);
        this.setNaturalidade(naturalidade);
    }

    public Pessoa(String nome, Escolaridade escolaridade) {
        this(nome, escolaridade, null);
    }

    public String getNomeCidadeNaturalidade() {
        if (this.naturalidade == null) {
            return "Naturalidade não informada";
        }
        return this.naturalidade.getNome();
    }

    public String getNomeEstadoNaturalidade() {
        if (this.naturalidade == null) {
            return "Naturalidade não informada";
        }
        return this.naturalidade.getNomeEstado();
    }

    public Cidade getNaturalidade() {
        return this.naturalidade;
    }

    public void setNaturalidade(Cidade naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEscolaridade() {
        return this.escolaridade.getNivel_escolar();
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        if (escolaridade == null) {
            throw new IllegalArgumentException("A pessoa deve possuir escolaridade.");
        }
        this.escolaridade = escolaridade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("A pessoa deve possuir um nome.");
        }
        this.nome = nome;
    }
}