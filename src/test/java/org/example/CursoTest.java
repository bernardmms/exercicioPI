package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CursoTest {

    @Test
    public void testConstructorEscolaNull() {
        Professor coord = new Professor("Ana", new Escolaridade("Superior"));
        try {
            new Curso(null, coord);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O curso deve pertencer a uma escola", e.getMessage());
        }
    }

    @Test
    public void testGetNomeCoordenadorNull() {
        Escola escola = new Escola();
        escola.setNome("Escola X");
        escola.setCidade(new Cidade("Cidade X", new Estado("XX")));
        Curso curso = new Curso(escola, null);
        assertEquals("Curso sem coordenador", curso.getNomeCoordenador());
    }

    @Test
    public void testGetNomeCoordenador() {
        Professor coord = new Professor("Carlos", new Escolaridade("Mestrado"));
        Escola escola = new Escola();
        escola.setNome("Escola Y");
        escola.setCidade(new Cidade("Cidade Y", new Estado("YY")));
        Curso curso = new Curso(escola, coord);
        assertEquals("Carlos", curso.getNomeCoordenador());
    }

    @Test
    public void testGetNomeDiretorEscola() {
        Professor diretor = new Professor("Paula", new Escolaridade("Doutorado"));
        Escola escola = new Escola();
        escola.setNome("Escola Z");
        escola.setCidade(new Cidade("Cidade Z", new Estado("ZZ")));
        escola.setDiretor(diretor);
        Curso curso = new Curso(escola, null);
        assertEquals("Paula", curso.getNomeDiretorEscola());
    }

    @Test
    public void testGetNomeTipoEnsinoNull() {
        Escola escola = new Escola();
        escola.setNome("Escola A");
        escola.setCidade(new Cidade("Cidade A", new Estado("AA")));
        Curso curso = new Curso(escola, new Professor("João", new Escolaridade("Superior")));
        assertEquals("Tipo de ensino não definido para o curso", curso.getNomeTipoEnsino());
    }

    @Test
    public void testSetTipoEnsino() {
        TipoEnsino tipo = new TipoEnsino("Presencial");
        Escola escola = new Escola();
        escola.setNome("Escola B");
        escola.setCidade(new Cidade("Cidade B", new Estado("BB")));
        Curso curso = new Curso(escola, new Professor("Marcos", new Escolaridade("Mestrado")));
        curso.setTipoEnsino(tipo);
        assertEquals("Presencial", curso.getNomeTipoEnsino());
        assertSame(tipo, curso.getTipoEnsino());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTipoEnsinoNull() {
        Escola escola = new Escola();
        escola.setNome("Escola C");
        escola.setCidade(new Cidade("Cidade C", new Estado("CC")));
        Curso curso = new Curso(escola, new Professor("Luiza", new Escolaridade("Superior")));
        curso.setTipoEnsino(null);
    }

    @Test
    public void testGetNomeEstadoEscolaWithoutCity() {
        Escola escola = new Escola();
        escola.setNome("Escola D");
        Curso curso = new Curso(escola, new Professor("Ana", new Escolaridade("Doutorado")));
        assertEquals("Escola sem cidade definida", curso.getNomeEstadoEscola());
    }

    @Test
    public void testGetNomeEstadoEscolaWithCity() {
        Escola escola = new Escola();
        escola.setNome("Escola E");
        escola.setCidade(new Cidade("Cidade E", new Estado("EE")));
        Curso curso = new Curso(escola, new Professor("Pedro", new Escolaridade("Mestrado")));
        assertEquals("EE", curso.getNomeEstadoEscola());
    }

    @Test
    public void testGetEscolaridadeCoordenadorNull() {
        Escola escola = new Escola();
        escola.setNome("Escola F");
        escola.setCidade(new Cidade("Cidade F", new Estado("FF")));
        Curso curso = new Curso(escola, null);
        assertEquals("Curso sem coordenador", curso.getEscolaridadeCoordenador());
    }

    @Test
    public void testGetEscolaridadeCoordenador() {
        Professor coord = new Professor("Beatriz", new Escolaridade("Especialização"));
        Escola escola = new Escola();
        escola.setNome("Escola G");
        escola.setCidade(new Cidade("Cidade G", new Estado("GG")));
        Curso curso = new Curso(escola, coord);
        assertEquals("Especialização", curso.getEscolaridadeCoordenador());
    }
}
