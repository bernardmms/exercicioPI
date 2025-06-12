package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    private Escolaridade escolaridade;
    private Cidade naturalidade;
    private Estado estado;

    @BeforeEach
    void setUp() {
        escolaridade = new Escolaridade("Superior Completo");
        estado = new Estado("SP");
        naturalidade = new Cidade("São Paulo", estado);
    }

    @Test
    void deveRetornarNome() {
        Pessoa pessoa = new Pessoa("Carlos", escolaridade, naturalidade);
        assertEquals("Carlos", pessoa.getNome());
    }

    @Test
    void deveRetornarEscolaridade() {
        Pessoa pessoa = new Pessoa("Ana", escolaridade);
        assertEquals("Superior Completo", pessoa.getEscolaridade());
    }

    @Test
    void deveRetornarNaturalidade() {
        Pessoa pessoa = new Pessoa("Bia", escolaridade, naturalidade);
        assertEquals(naturalidade, pessoa.getNaturalidade());
    }

    @Test
    void deveRetornarNomeCidadeNaturalidade() {
        Pessoa pessoa = new Pessoa("Pedro", escolaridade, naturalidade);
        assertEquals("São Paulo", pessoa.getNomeCidadeNaturalidade());
    }

    @Test
    void deveRetornarNaturalidadeNaoInformadaParaCidade() {
        Pessoa pessoa = new Pessoa("Mariana", escolaridade);
        assertEquals("Naturalidade não informada", pessoa.getNomeCidadeNaturalidade());
    }

    @Test
    void deveRetornarNomeEstadoNaturalidade() {
        Pessoa pessoa = new Pessoa("João", escolaridade, naturalidade);
        assertEquals("SP", pessoa.getNomeEstadoNaturalidade());
    }

    @Test
    void deveRetornarNaturalidadeNaoInformadaParaEstado() {
        Pessoa pessoa = new Pessoa("Lucas", escolaridade);
        assertEquals("Naturalidade não informada", pessoa.getNomeEstadoNaturalidade());
    }

    @Test
    void deveLancarExcecaoNomeNulo() {
        try {
            Pessoa pessoa = new Pessoa(null, escolaridade, naturalidade);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A pessoa deve possuir um nome.", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoSetNomeNulo() {
        try {
            Pessoa pessoa = new Pessoa("José", escolaridade);
            pessoa.setNome(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A pessoa deve possuir um nome.", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoEscolaridadeNula() {
        try {
            Pessoa pessoa = new Pessoa("Fernanda", null, naturalidade);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A pessoa deve possuir escolaridade.", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoSetEscolaridadeNula() {
        try {
            Pessoa pessoa = new Pessoa("Gabriela", escolaridade);
            pessoa.setEscolaridade(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A pessoa deve possuir escolaridade.", e.getMessage());
        }
    }

    @Test
    void deveAlterarNome() {
        Pessoa pessoa = new Pessoa("Rafael", escolaridade);
        pessoa.setNome("Rafaela");
        assertEquals("Rafaela", pessoa.getNome());
    }

    @Test
    void deveAlterarEscolaridade() {
        Pessoa pessoa = new Pessoa("Tiago", escolaridade);
        Escolaridade novaEscolaridade = new Escolaridade("Mestrado");
        pessoa.setEscolaridade(novaEscolaridade);
        assertEquals("Mestrado", pessoa.getEscolaridade());
    }

    @Test
    void deveAlterarNaturalidade() {
        Pessoa pessoa = new Pessoa("Vinicius", escolaridade);
        pessoa.setNaturalidade(naturalidade);
        assertEquals(naturalidade, pessoa.getNaturalidade());
        assertEquals("São Paulo", pessoa.getNomeCidadeNaturalidade());
        assertEquals("SP", pessoa.getNomeEstadoNaturalidade());
    }
}