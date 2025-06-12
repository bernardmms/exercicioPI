package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lista {

    // Questão A
    @Test
    public void testaEscolaridadeProfessor() {
        Escolaridade graduado = new Escolaridade("Graduado");
        Professor carlos = new Professor("Carlos", graduado);
        assertEquals("Graduado", carlos.getEscolaridade());
    }

    // Questão B1
    @Test
    public void deveRetornarEscolaridadeCoordenador() {
        Escolaridade escolaridadeDoutorado = new Escolaridade("Doutorado");
        Professor coordenador = new Professor("Ana Silva", escolaridadeDoutorado);
        Escola escola = new Escola();
        Curso curso = new Curso(escola, coordenador);

        assertEquals("Doutorado", curso.getEscolaridadeCoordenador());
    }

    // Questão B2
    @Test
    public void deveRetornarMensagemSeCursoNaoTiverCoordenador() {
        Escola escola = new Escola();
        Curso curso = new Curso(escola, null);

        assertEquals("Curso sem coordenador", curso.getEscolaridadeCoordenador());
    }

    // Questão C1
    @Test
    public void deveRetornarEscolaridadeDiretor() {
        Escolaridade escolaridadeMestrado = new Escolaridade("Mestrado");
        Professor diretor = new Professor("Carlos Andrade", escolaridadeMestrado);
        Escola escola = new Escola();
        escola.setDiretor(diretor);

        assertEquals("Mestrado", escola.getEscolaridadeDiretor());
    }

    // Questão C2
    @Test
    public void deveRetornarMensagemSeEscolaNaoTiverDiretor() {
        Escola escola = new Escola();
        escola.setDiretor(null);

        assertEquals("Escola sem diretor", escola.getEscolaridadeDiretor());
    }

    // Questão D
    @Test
    public void deveRetornarEstadoNaturalidadeAluno() {
        Estado estadoNaturalidade = new Estado("Minas Gerais");
        Cidade cidadeNaturalidade = new Cidade("Belo Horizonte", estadoNaturalidade);
        Escolaridade escolaridade = new Escolaridade("Ensino Médio");

        Estado estadoEscola = new Estado("RJ");
        Cidade cidadeEscola = new Cidade("Rio de Janeiro", estadoEscola);
        Escola escola = new Escola();
        escola.setCidade(cidadeEscola);
        Professor coordenador = new Professor("Prof. Teste", new Escolaridade("Doutorado"));
        Curso curso = new Curso(escola, coordenador);

        Aluno aluno = new Aluno("Mariana Costa", escolaridade, cidadeNaturalidade, curso);

        assertEquals("Minas Gerais", aluno.getNomeEstadoNaturalidade());
    }

    // Questão E
    @Test
    public void deveRetornarCidadeNaturalidadeProfessor() {
        Estado estado = new Estado("São Paulo");
        Cidade cidade = new Cidade("Campinas", estado);
        Escolaridade escolaridade = new Escolaridade("Doutorado");
        Professor professor = new Professor("João Mendes", escolaridade);
        professor.setNaturalidade(cidade);

        assertEquals("Campinas", professor.getNomeCidadeNaturalidade());
    }

    // Questão F
    @Test
    public void deveRetornarEstadoOndeAlunoEstuda() {
        Estado estadoDaEscola = new Estado("Rio de Janeiro");
        Cidade cidadeDaEscola = new Cidade("Niterói", estadoDaEscola);
        Escola escola = new Escola();
        escola.setCidade(cidadeDaEscola);

        Professor coordenador = new Professor("Fabiana Lima", new Escolaridade("Mestrado"));
        Curso curso = new Curso(escola, coordenador);

        Aluno aluno = new Aluno("Pedro Alves", new Escolaridade("Graduação Incompleta"), null, curso);

        assertEquals("Rio de Janeiro", aluno.getNomeEstadoOndeEstuda());
    }

    // Questão G
    @Test
    public void deveRetornarTipoEnsinoDoCursoCoordenadoPeloProfessor() {
        TipoEnsino tipoEnsino = new TipoEnsino("Ensino Superior");
        Escolaridade escolaridadeProfessor = new Escolaridade("Doutorado");
        Professor professor = new Professor("Ricardo", escolaridadeProfessor);

        Escola escola = new Escola();
        escola.setCidade(new Cidade("Juiz de Fora", new Estado("Minas Gerais")));

        Curso curso = new Curso(escola, professor);
        curso.setTipoEnsino(tipoEnsino);

        assertEquals("Ensino Superior", curso.getNomeTipoEnsino());
    }

    // Questão H1
    @Test
    public void deveRetornarNomeDoCoordenadorDoCursoDoAluno() {
        Escolaridade escolaridadeCoordenador = new Escolaridade("Doutorado");
        Professor coordenador = new Professor("Helena Martins", escolaridadeCoordenador);

        Escola escola = new Escola();
        escola.setCidade(new Cidade("São Paulo", new Estado("SP")));

        Curso curso = new Curso(escola, coordenador);
        curso.setTipoEnsino(new TipoEnsino("Engenharia de Software"));

        Aluno aluno = new Aluno("Carlos Pereira", new Escolaridade("Graduação Incompleta"), null, curso);

        assertEquals("Helena Martins", aluno.getNomeCoordenadorDoCurso());
    }

    // Questão H2
    @Test
    public void deveRetornarCursoSemCoordenador() {
        Escolaridade escolaridadeCoordenador = new Escolaridade("Doutorado");
        Professor coordenador = new Professor("Helena Martins", escolaridadeCoordenador);

        Escola escola = new Escola();
        escola.setCidade(new Cidade("São Paulo", new Estado("SP")));

        Curso curso = new Curso(escola, null);
        curso.setTipoEnsino(new TipoEnsino("Engenharia de Software"));

        Aluno aluno = new Aluno("Carlos Pereira", new Escolaridade("Graduação Incompleta"), null, curso);

        assertEquals("Curso sem coordenador", aluno.getNomeCoordenadorDoCurso());
    }

    // Questão I1
    @Test
    public void deveRetornarNomeDoDiretorDaEscolaOndeProfessorTrabalha() {
        Professor diretor = new Professor("Marco Antônio", new Escolaridade("PhD"));

        Escola escola = new Escola();
        escola.setCidade(new Cidade("Juiz de Fora", new Estado("Minas Gerais")));
        escola.setDiretor(diretor);

        Professor professor = new Professor("Ana Paula", new Escolaridade("Mestrado"));

        Curso curso = new Curso(escola, professor);

        assertEquals("Marco Antônio", curso.getNomeDiretorEscola());
    }

    // Questão I2
    @Test
    public void deveRetornarEscolaSemDiretor() {
        Escola escola = new Escola();
        escola.setCidade(new Cidade("Juiz de Fora", new Estado("Minas Gerais")));
        escola.setDiretor(null);

        Professor professor = new Professor("Ana Paula", new Escolaridade("Mestrado"));

        Curso curso = new Curso(escola, professor);

        assertEquals("Escola sem diretor", curso.getNomeDiretorEscola());
    }

    // Questão J1
    @Test
    public void deveRetornarNomeDoCoordenadorDoCursoDeUmProfessor() {
        Professor coordenadorDoCurso = new Professor("Carlos Andrade", new Escolaridade("Doutorado"));
        Professor professorDoCurso = new Professor("Beatriz Lima", new Escolaridade("Mestrado"));

        Escola escola = new Escola();
        escola.setCidade(new Cidade("Belo Horizonte", new Estado("Minas Gerais")));

        Curso curso = new Curso(escola, coordenadorDoCurso);

        String esperado = "Carlos Andrade";

        String resultado = curso.getNomeCoordenador();

        assertEquals(esperado, resultado);
    }

    // Questão J2
    @Test
    public void deveRetornarProprioNomeSeProfessorForOCoordenador() {
        Professor professorQueTambemECoordenador = new Professor("Carlos Andrade", new Escolaridade("Doutorado"));

        Escola escola = new Escola();
        escola.setCidade(new Cidade("Belo Horizonte", new Estado("Minas Gerais")));

        Curso curso = new Curso(escola, professorQueTambemECoordenador);

        String esperado = "Carlos Andrade";

        String resultado = curso.getNomeCoordenador();

        assertEquals(esperado, resultado);
    }
}