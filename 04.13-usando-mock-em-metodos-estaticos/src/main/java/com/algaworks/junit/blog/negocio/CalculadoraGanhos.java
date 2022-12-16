package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;
import com.algaworks.junit.blog.modelo.Ganhos;
import com.algaworks.junit.blog.modelo.Post;

import java.math.BigDecimal;
import java.util.Objects;

public class CalculadoraGanhos {

    private final ProcessadorTexto processadorTexto;
    private final BigDecimal bonusPremium;

    public CalculadoraGanhos(ProcessadorTexto processadorTexto,
                             BigDecimal bonusPremium) {
        Objects.requireNonNull(processadorTexto);
        Objects.requireNonNull(bonusPremium);
        this.processadorTexto = processadorTexto;
        this.bonusPremium = bonusPremium;
    }

    public Ganhos calcular(Post post) {
        Objects.requireNonNull(post);
        Editor autor = post.getAutor();
        Objects.requireNonNull(autor);

        BigDecimal valorPagoPorPalavra = autor.getValorPagoPorPalavra();
        int quantidadePalavras = processadorTexto.quantidadePalavras(post.getConteudo());
        BigDecimal totalGanho = valorPagoPorPalavra.multiply(BigDecimal.valueOf(quantidadePalavras));

        if (post.getAutor().isPremium()) {
            totalGanho = totalGanho.add(bonusPremium);
        }

        return new Ganhos(valorPagoPorPalavra, quantidadePalavras, totalGanho);
    }
}
