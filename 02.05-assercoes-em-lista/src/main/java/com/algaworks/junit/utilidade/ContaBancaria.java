package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    public ContaBancaria(BigDecimal saldo) {
        //TODO 1 - validar saldo: não pode ser nulo, case seja deve lançar uma IllegalArgumentException
        //TODO 2 - pode ser zero ou negativo
    }

    public void saque(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo ou menor que zero, case seja deve lançar uma IllegalArgumentException
        //TODO 2 - Deve subtrair o valor do saldo
        //TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException
    }

    public void deposito(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo ou menor que zero uma IllegalArgumentException
        //TODO 2 - Deve adicionar o valor ao saldo
        //TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException
    }

    public BigDecimal saldo() {
        //TODO 1 - retornar saldo
        return null;
    }
}
