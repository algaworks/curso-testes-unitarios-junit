package com.algaworks.junit.utilidade;

public enum Multiplicador {
    DOBRO(2.0),
    TRIPLO(3.0),
    QUADRUPLO(4.0);

    private final double multiplicador;

    Multiplicador(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    Double aplicarMultiplicador(Double valor) {
        if (valor == null || valor == 0) {
            return 0.0;
        }
        return multiplicador * valor;
    }

}