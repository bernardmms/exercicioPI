package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class EstadoTest {

    @Test
    public void testConstructorAndGetNome() {
        Estado estado = new Estado("SP");
        assertEquals("SP", estado.getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorComNomeNull() {
        new Estado(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNomeNull() {
        Estado estado = new Estado("RJ");
        estado.setNome(null);
    }

    @Test
    public void testSetNomeValido() {
        Estado estado = new Estado("MG");
        estado.setNome("BA");
        assertEquals("BA", estado.getNome());
    }
}
