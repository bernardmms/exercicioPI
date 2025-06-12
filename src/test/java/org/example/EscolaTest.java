package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class EscolaTest {

    @Test
    public void testSetNomeNull() {
        Escola escola = new Escola();
        try {
            escola.setNome(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A escola deve possuir um nome", e.getMessage());
        }
    }

    @Test
    public void testSetNomeAndGetNome() {
        Escola escola = new Escola();
        escola.setNome("Escola H");
        assertEquals("Escola H", escola.getNome());
    }

    @Test
    public void testGetNomeDiretorNull() {
        Escola escola = new Escola();
        assertEquals("Escola sem diretor", escola.getNomeDiretor());
    }

    @Test
    public void testGetNomeDiretor() {
        Professor diretor = new Professor("Ricardo", new Escolaridade("Doutorado"));
        Escola escola = new Escola();
        escola.setNome("Escola I");
        escola.setDiretor(diretor);
        assertEquals("Ricardo", escola.getNomeDiretor());
    }

    @Test
    public void testGetEscolaridadeDiretorNull() {
        Escola escola = new Escola();
        assertEquals("Escola sem diretor", escola.getEscolaridadeDiretor());
    }

    @Test
    public void testGetEscolaridadeDiretor() {
        Professor diretor = new Professor("Sofia", new Escolaridade("Mestrado"));
        Escola escola = new Escola();
        escola.setNome("Escola J");
        escola.setDiretor(diretor);
        assertEquals("Mestrado", escola.getEscolaridadeDiretor());
    }

    @Test
    public void testGetNomeEstadoWithoutCity() {
        Escola escola = new Escola();
        assertEquals("Escola sem cidade definida", escola.getNomeEstado());
    }

    @Test
    public void testSetCidadeNull() {
        Escola escola = new Escola();
        try {
            escola.setCidade(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A escola deve pertencer a uma cidade.", e.getMessage());
        }
    }

    @Test
    public void testSetCidadeAndGetNomeEstado() {
        Escola escola = new Escola();
        Estado estado = new Estado("ZZ");
        Cidade cidade = new Cidade("Cidade Z", estado);
        escola.setCidade(cidade);
        assertEquals("ZZ", escola.getNomeEstado());
    }
}
