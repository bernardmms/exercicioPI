package org.example;

public class Escola {
    private String nome;
    private Cidade cidade;
    private Professor diretor;

    public String getNomeDiretor() {
        if (this.diretor == null) {
            return "Escola sem diretor";
        }
        return this.diretor.getNome();
    }

    public String getNomeEstado() {
        if (this.cidade == null) {
            return "Escola sem cidade definida";
        }
        return this.cidade.getNomeEstado();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        if (cidade == null) {
            throw new IllegalArgumentException("A escola deve pertencer a uma cidade.");
        }
        this.cidade = cidade;
    }

    public Professor getDiretor() {
        return this.diretor;
    }

    public void setDiretor(Professor diretor) {
        this.diretor = diretor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("A escola deve possuir um nome");
        }
        this.nome = nome;
    }

    public String getEscolaridadeDiretor() {
        if (this.diretor == null) {
            return "Escola sem diretor";
        }
        return this.diretor.getEscolaridade();
    }
}