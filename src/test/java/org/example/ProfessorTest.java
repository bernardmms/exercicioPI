package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    private Escolaridade escolaridade;

    @BeforeEach
    void setUp() {
        escolaridade = new Escolaridade("Doutorado");
    }

    @Test
    void deveInstanciarProfessorCorretamente() {
        Professor professor = new Professor("Marco Aurélio", escolaridade);
        assertEquals("Marco Aurélio", professor.getNome());
        assertEquals("Doutorado", professor.getEscolaridade());
    }
}