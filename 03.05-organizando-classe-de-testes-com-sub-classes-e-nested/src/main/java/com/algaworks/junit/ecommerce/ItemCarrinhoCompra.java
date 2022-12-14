package com.algaworks.junit.ecommerce;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemCarrinhoCompra {

    private final Produto produto;
    private int quantidade;

    public ItemCarrinhoCompra(Produto produto, int quantidade) {
        Objects.requireNonNull(produto);
        if (quantidade <= 0) {
            throw new IllegalArgumentException();
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public BigDecimal getValorTotal() {
        return this.produto.getValor()
                .multiply(new BigDecimal(quantidade));
    }

    public void adicionarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException();
        }
        this.quantidade += quantidade;
    }

    public void subtrairQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException();
        }
        if (quantidade >= this.quantidade) {
            throw new IllegalArgumentException();
        }
        this.quantidade -= quantidade;
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
