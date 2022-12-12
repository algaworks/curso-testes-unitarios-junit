package com.algaworks.junit.ecommerce;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemCarrinhoCompra {

    private Produto produto;
    private int quantidade;

    public ItemCarrinhoCompra(Produto produto, int quantidade) {
        //TODO parâmetros não podem ser nulos
        //TODO quantidade não pode ser menor que 1
	}

    public Produto getProduto() {
    	return this.produto;
    }

    public int getQuantidade() {
    	return this.quantidade;
    }

    public BigDecimal getValorTotal() {
        //TODO retornar produto.valor * quantidade
        return null;
    }

	public void adicionarQuantidade(int quantidade) {
        //TODO quantidade não pode ser menor que 1
        //TODO Deve somar o valor atual da quantidade com o valor passado
	}

    public void subtrairQuantidade(int quantidade) {
        //TODO quantidade não pode ser menor que 1
        //TODO Deve subtrair o valor atual da quantidade com o valor passado
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrinhoCompra that = (ItemCarrinhoCompra) o;
        return quantidade == that.quantidade && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, quantidade);
    }
}
