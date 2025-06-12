package org.example;

public class Aluno extends Pessoa {
    private Curso curso;

    public Aluno(String nome, Escolaridade escolaridade, Cidade naturalidade, Curso curso) {
        super(nome, escolaridade, naturalidade);
        this.setCurso(curso);
    }

    public String getNomeCoordenadorDoCurso() {
        return this.curso.getNomeCoordenador();
    }

    public String getNomeEstadoOndeEstuda() {

        return this.curso.getNomeEstadoEscola();
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso não pode ser nulo.");
        }
        this.curso = curso;
    }
}