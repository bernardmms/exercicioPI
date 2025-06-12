package org.example;

public class Curso {
    private Escola escola;
    private Professor coordenador;
    private TipoEnsino tipoEnsino;

    public Curso(Escola escola, Professor coordenador) {
        this.setEscola(escola);
        this.setCoordenador(coordenador);
    }

    public String getNomeCoordenador() {
        if (this.coordenador == null) {
            return "Curso sem coordenador";
        }
        return this.coordenador.getNome();
    }

    public String getNomeDiretorEscola() {
        if (this.escola == null) {
            return "Curso não associado a uma escola";
        }
        return this.escola.getNomeDiretor();
    }

    public String getNomeTipoEnsino() {
        if (this.tipoEnsino == null) {
            return "Tipo de ensino não definido para o curso";
        }
        return this.tipoEnsino.getNome();
    }

    public TipoEnsino getTipoEnsino() {
        return this.tipoEnsino;
    }

    public void setTipoEnsino(TipoEnsino tipoEnsino) {
        if (tipoEnsino == null) {
            throw new IllegalArgumentException("O curso deve possuir um tipo de ensino.");
        }
        this.tipoEnsino = tipoEnsino;
    }

    public String getNomeEstadoEscola() {
        if (this.escola == null) {
            return "Curso não associado a uma escola";
        }
        return this.escola.getNomeEstado();
    }

    public Escola getEscola() {
        return this.escola;
    }

    public void setEscola(Escola escola) {
        if (escola == null) {
            throw new IllegalArgumentException("O curso deve pertencer a uma escola");
        }
        this.escola = escola;
    }

    public Professor getCoordenador() {
        return this.coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }

    public String getEscolaridadeCoordenador() {
        if (this.coordenador == null) {
            return "Curso sem coordenador";
        }
        return this.coordenador.getEscolaridade();
    }
}