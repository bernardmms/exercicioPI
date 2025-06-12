package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlunoTest {

    @Test
    public void testConstrutorAlunoComCurso() {
        Estado estadoNat = new Estado("PE");
        Cidade cidade = new Cidade("Recife", estadoNat);
        Escolaridade escolaridade = new Escolaridade("Médio");
        Professor coordenador = new Professor("Carlos", new Escolaridade("Superior"));
        Escola escola = new Escola();
        escola.setCidade(cidade);
        Curso curso = new Curso(escola, coordenador);
        Aluno aluno = new Aluno("João", escolaridade, cidade, curso);
        assertEquals("João", aluno.getNome());
        assertEquals("Recife", aluno.getNomeCidadeNaturalidade());
        assertEquals("Carlos", aluno.getNomeCoordenadorDoCurso());
        assertEquals("PE", aluno.getNomeEstadoOndeEstuda());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCursoNaoPodeSerNulo() {
        Estado estadoNat = new Estado("CE");
        Cidade cidade = new Cidade("Fortaleza", estadoNat);
        Escolaridade escolaridade = new Escolaridade("Médio");
        new Aluno("Maria", escolaridade, cidade, null);
    }

    @Test
    public void testCursoSemCoordenador() {
        Escola escola = new Escola();
        Curso curso = new Curso(escola, null);
        Estado estadoNat = new Estado("BA");
        Cidade cidade = new Cidade("Salvador", estadoNat);
        Escolaridade escolaridade = new Escolaridade("Médio");
        Aluno aluno = new Aluno("Lucas", escolaridade, cidade, curso);
        assertEquals("Curso sem coordenador", aluno.getNomeCoordenadorDoCurso());
    }

    @Test
    public void testSetCursoValido() {
        Escola escola = new Escola();
        Professor coordenador = new Professor("Joana", new Escolaridade("Mestrado"));
        Curso curso = new Curso(escola, coordenador);
        Estado estadoNat = new Estado("AM");
        Cidade cidade = new Cidade("Manaus", estadoNat);
        Escolaridade escolaridade = new Escolaridade("Médio");
        Aluno aluno = new Aluno("Bruno", escolaridade, cidade, curso);
        Curso novoCurso = new Curso(escola, new Professor("Marcos", new Escolaridade("Superior")));
        aluno.setCurso(novoCurso);
        assertEquals("Marcos", aluno.getNomeCoordenadorDoCurso());
    }
}
