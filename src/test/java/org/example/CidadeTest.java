package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CidadeTest {

    @Test
    public void testConstructorAndGetters() {
        Estado estado = new Estado("PE");
        Cidade cidade = new Cidade("Recife", estado);
        assertEquals("Recife", cidade.getNome());
        assertSame(estado, cidade.getEstado());
        assertEquals("PE", cidade.getNomeEstado());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNomeNull() {
        Estado estado = new Estado("CE");
        new Cidade(null, estado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEstadoNull() {
        new Cidade("Fortaleza", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNomeNull() {
        Estado estado = new Estado("BA");
        Cidade cidade = new Cidade("Salvador", estado);
        cidade.setNome(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetEstadoNull() {
        Estado estado = new Estado("RN");
        Cidade cidade = new Cidade("Natal", estado);
        cidade.setEstado(null);
    }

    @Test
    public void testSetNomeAndEstadoValido() {
        Estado estado1 = new Estado("AM");
        Estado estado2 = new Estado("AP");
        Cidade cidade = new Cidade("Manaus", estado1);
        cidade.setNome("Macapá");
        cidade.setEstado(estado2);
        assertEquals("Macapá", cidade.getNome());
        assertSame(estado2, cidade.getEstado());
        assertEquals("AP", cidade.getNomeEstado());
    }
}
