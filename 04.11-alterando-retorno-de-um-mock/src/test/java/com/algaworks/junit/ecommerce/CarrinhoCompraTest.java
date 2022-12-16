package com.algaworks.junit.ecommerce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Carrinho de compras")
class CarrinhoCompraTest {

    private CarrinhoCompra carrinhoCompra;
    private Cliente cliente;
    private List<ItemCarrinhoCompra> itens;
    private Produto notebook;
    private Produto desktop;
    private Produto tablet;

    @Nested
    @DisplayName("Dado um carrinho de três itens")
    class DadoUmCarrinhoComDoisItens {

        @BeforeEach
        public void beforeEach() {
            cliente = new Cliente(1L, "Alex Silva");

            notebook = new Produto(1L, "Notebook", "Notebook", BigDecimal.TEN);
            desktop = new Produto(2L, "Desktop", "Desktop", BigDecimal.valueOf(20.50));
            tablet = new Produto(3L, "Tablet", "Tablet", BigDecimal.valueOf(30.50));

            itens = new ArrayList<>();
            itens.add(new ItemCarrinhoCompra(notebook, 2));
            itens.add(new ItemCarrinhoCompra(desktop, 1));

            carrinhoCompra = new CarrinhoCompra(cliente, itens);
        }

        @Nested
        @DisplayName("Quando retornar itens")
        class QuandoRetornarItens {

            @Test
            @DisplayName("Então deve retornar dois itens")
            void entaoDeveRetornarDoisItens() {
                assertEquals(2, carrinhoCompra.getItens().size());
            }

            @Test
            @DisplayName("E deve retornar uma nova instância da lista de itens")
            void eDeveRetornarUmaNovaLista() {
                carrinhoCompra.getItens().clear(); //Get Itens, retorna uma nova lista
                assertEquals(2, carrinhoCompra.getItens().size()); //Lista permaneceu intacta
            }

        }

        @Nested
        @DisplayName("Quando remover um notebook")
        class QuandoRemoverUmItem {

            @BeforeEach
            public void beforeEach() {
                carrinhoCompra.removerProduto(notebook);
            }

            @Test
            @DisplayName("Então deve diminuir a quantidade total de itens")
            void entaoDeveDiminuirQuantidadeTotal() {
                assertEquals(1, carrinhoCompra.getItens().size());
            }

            @Test
            @DisplayName("E não deve remover demais itens")
            void naoDeveRemoverDemaisItens() {
                assertEquals(desktop, carrinhoCompra.getItens().get(0).getProduto());
            }

        }

        @Nested
        @DisplayName("Quando aumentar quantidade de um notebook")
        class QuandoAumentarQuantidade {

            @BeforeEach
            void beforeEach() {
                carrinhoCompra.aumentarQuantidadeProduto(notebook);
            }

            @Test
            @DisplayName("Então deve somar na quantidade dos itens iguais")
            void deveSomarNaQuantidade() {
                assertEquals(3, carrinhoCompra.getItens().get(0).getQuantidade());
                assertEquals(1, carrinhoCompra.getItens().get(1).getQuantidade());
            }

            @Test
            @DisplayName("Então deve retornar quatro de quantidade total de itens")
            void deveRetornarQuantidadeTotalItens() {
                assertEquals(4, carrinhoCompra.getQuantidadeTotalDeProdutos());
            }

            @Test
            @DisplayName("Então deve retornar valor total correto de itens")
            void deveRetornarValorTotalItens() {
                assertEquals(new BigDecimal("50.5"), carrinhoCompra.getValorTotal());
            }
        }

        @Nested
        @DisplayName("Quando diminuir quantidade de um notebook")
        class QuandoDiminuirQuantidade {

            @BeforeEach
            void beforeEach() {
                carrinhoCompra.diminuirQuantidadeProduto(notebook);
            }

            @Test
            @DisplayName("Então deve somar na quantidade dos itens iguais")
            void deveSomarNaQuantidade() {
                assertEquals(1, carrinhoCompra.getItens().get(0).getQuantidade());
                assertEquals(1, carrinhoCompra.getItens().get(1).getQuantidade());
            }

            @Test
            @DisplayName("Então deve retornar três de quantidade total de itens")
            void deveRetornarQuantidadeTotalItens() {
                assertEquals(2, carrinhoCompra.getQuantidadeTotalDeProdutos());
            }

            @Test
            @DisplayName("Então deve retornar valor total correto de itens")
            void deveRetornarValorTotalItens() {
                assertEquals(new BigDecimal("30.5"), carrinhoCompra.getValorTotal());
            }
        }

        @Nested
        @DisplayName("Quando diminuir quantidade de um item com apenas um de quantidade")
        class QuandoDiminuirQuantidadeDeItemUnico {

            @BeforeEach
            void beforeEach() {
                carrinhoCompra.diminuirQuantidadeProduto(desktop);
            }

            @Test
            @DisplayName("Então deve remover item")
            void entaoDeveRemoverItem() {
                assertNotEquals(carrinhoCompra.getItens().get(0).getProduto(), desktop);
            }
        }

        @Nested
        @DisplayName("Quando adiconar item com quantidade inválida")
        class QuandoAdicionarItemComQuantidadeInvalida {

            @Test
            @DisplayName("Então deve lançar exception")
            void entaoDeveFalhar() {
                assertThrows(RuntimeException.class, ()-> carrinhoCompra.adicionarProduto(desktop, -1));
            }
        }

        @Nested
        @DisplayName("Quando esvaziar carrinho")
        class QuandoEsvaziarCarrinho {

            @BeforeEach
            void beforeEach() {
                carrinhoCompra.esvaziar();
            }

            @Test
            @DisplayName("Então deve somar na quantidade dos itens iguais")
            void deveSomarNaQuantidade() {
                assertEquals(0, carrinhoCompra.getItens().size());
            }

            @Test
            @DisplayName("Então deve retornar zero de quantidade total de itens")
            void deveRetornarQuantidadeTotalItens() {
                assertEquals(0, carrinhoCompra.getQuantidadeTotalDeProdutos());
            }

            @Test
            @DisplayName("Então deve retornar zero de valor total de itens")
            void deveRetornarValorTotalItens() {
                assertEquals(BigDecimal.ZERO, carrinhoCompra.getValorTotal());
            }
        }

    }

    @Nested
    @DisplayName("Dado um carrinho vazio")
    class DadoUmCarinhoVazio {

        @BeforeEach
        public void beforeEach() {
            cliente = new Cliente(1L, "Alex Silva");

            notebook = new Produto(1L, "Notebook", "Notebook", BigDecimal.TEN);
            desktop = new Produto(2L, "Desktop", "Desktop", BigDecimal.valueOf(20.50));
            tablet = new Produto(3L, "Tablet", "Tablet", BigDecimal.valueOf(30.50));

            itens = new ArrayList<>();

            carrinhoCompra = new CarrinhoCompra(cliente, itens);
        }

        @Nested
        @DisplayName("Quando adicionar dois notebooks iguais e um desktop")
        class QuandoAdicionarDoisItensIguais {

            @BeforeEach
            void beforeEach() {
                carrinhoCompra.adicionarProduto(notebook, 1);
                carrinhoCompra.adicionarProduto(notebook, 1);
                carrinhoCompra.adicionarProduto(desktop, 1);
            }

            @Test
            @DisplayName("Então deve somar na quantidade dos itens iguais")
            void entaoDeveSomarNaQuantidade() {
                assertEquals(2, carrinhoCompra.getItens().get(0).getQuantidade());
                assertEquals(1, carrinhoCompra.getItens().get(1).getQuantidade());
            }

            @Test
            @DisplayName("E retornar três de quantidade total de itens")
            void eRetornarQuantidadeTotalItens() {
                assertEquals(3, carrinhoCompra.getQuantidadeTotalDeProdutos());
            }

            @Test
            @DisplayName("E retornar valor total correto de itens")
            void eRetornarValorTotalItens() {
                assertEquals(new BigDecimal("40.5"), carrinhoCompra.getValorTotal());
            }

        }

    }
}