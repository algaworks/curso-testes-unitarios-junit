package com.algaworks.junit.ecommerce;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private Long id;
    private String nome;
	private String descricao;
	private BigDecimal valor;

	public Produto(Long id, String nome, String descricao, BigDecimal valor) {
		//TODO parâmetros não podem ser nulos, deve retornar uma Exception
		//TODO valor não pode ser menor que 1, deve retornar uma Exception
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Produto produto = (Produto) o;
		return Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao) && Objects.equals(valor, produto.valor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, descricao, valor);
	}
}