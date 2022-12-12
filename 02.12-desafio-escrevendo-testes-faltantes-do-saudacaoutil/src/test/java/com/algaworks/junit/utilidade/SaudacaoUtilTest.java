package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    public void saudarComBomDia() {
        int horaValida = 9;
        String saudacao = saudar(horaValida);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    public void saudarComBoaTarde() {
        int horaValida = 15;
        String saudacao = saudar(horaValida);
        assertEquals("Boa tarde", saudacao);
    }

    @Test
    public void saudarComBoaNoite() {
        int horaValida = 22;
        String saudacao = saudar(horaValida);
        assertEquals("Boa noite", saudacao);
    }

    @Test
    public void deveLancarException() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> saudar(-10));
        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    public void naoDeveLancarException() {
        assertDoesNotThrow(()-> saudar(0));
    }

}