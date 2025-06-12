package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EscolaridadeTest {

    @Test
    void deveRetornarNivelEscolar() {
        Escolaridade escolaridade = new Escolaridade("Ensino Médio");
        assertEquals("Ensino Médio", escolaridade.getNivel_escolar());
    }

    @Test
    void deveLancarExcecaoNivelEscolarNuloConstrutor() {
        try {
            Escolaridade escolaridade = new Escolaridade(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nivel de escolaridade não pode ser nulo", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoSetNivelEscolarNulo() {
        try {
            Escolaridade escolaridade = new Escolaridade("Ensino Superior");
            escolaridade.setNivel_escolar(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nivel de escolaridade não pode ser nulo", e.getMessage());
        }
    }

    @Test
    void deveAlterarNivelEscolar() {
        Escolaridade escolaridade = new Escolaridade("Ensino Fundamental");
        escolaridade.setNivel_escolar("Pós-graduação");
        assertEquals("Pós-graduação", escolaridade.getNivel_escolar());
    }
}