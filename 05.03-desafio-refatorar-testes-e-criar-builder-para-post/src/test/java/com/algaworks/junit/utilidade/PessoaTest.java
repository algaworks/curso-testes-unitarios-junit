package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void assercaoAgrupada() {
        Pessoa pessoa = new Pessoa("Alex", "Silva");

        assertAll("Asserções de pessoa",
                ()-> assertEquals("Alex", pessoa.getNome()),
                ()-> assertEquals("Silva", pessoa.getSobrenome()));
    }

}