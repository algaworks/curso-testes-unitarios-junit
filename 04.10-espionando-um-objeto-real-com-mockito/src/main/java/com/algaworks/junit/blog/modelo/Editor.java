package com.algaworks.junit.blog.modelo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Editor {
    private Long id;
    private String nome;
    private String email;
    private BigDecimal valorPagoPorPalavra;
    private boolean premium;
    private OffsetDateTime dataCriacao = OffsetDateTime.now();

    public Editor() {

    }

    public Editor(String nome, String email, BigDecimal valorPagoPorPalavra, boolean premium) {
        this(null, nome, email, valorPagoPorPalavra, premium);
    }

    public Editor(Long id, String nome, String email, BigDecimal valorPagoPorPalavra, boolean premium) {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(email);
        Objects.requireNonNull(valorPagoPorPalavra);
        this.id = id; //Pode ser nulo, caso seja um editor novo
        this.nome = nome;
        this.email = email;
        this.valorPagoPorPalavra = valorPagoPorPalavra;
        this.premium = premium;
    }

    /**
     * Atualiza apenas com dados permitidos
     * @param editor
     */
    public void atualizarComDados(Editor editor) {
        Objects.requireNonNull(editor);
        this.nome = editor.nome;
        this.email = editor.email;
        this.valorPagoPorPalavra = editor.valorPagoPorPalavra;
        this.premium = editor.premium;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getValorPagoPorPalavra() {
        return valorPagoPorPalavra;
    }

    public void setValorPagoPorPalavra(BigDecimal valorPagoPorPalavra) {
        this.valorPagoPorPalavra = valorPagoPorPalavra;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editor editor = (Editor) o;
        return Objects.equals(id, editor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public final static class Builder {

        private Long id;
        private String nome;
        private String email;
        private BigDecimal valorPagoPorPalavra;
        private boolean premium;

        private Builder() {

        }

        public Builder comId(Long id) {
            this.id = id;
            return this;
        }

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder comEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder comValorPagoPorPalavra(BigDecimal valorPagoPorPalavra) {
            this.valorPagoPorPalavra = valorPagoPorPalavra;
            return this;
        }

        public Builder comPremium(boolean premium) {
            this.premium = premium;
            return this;
        }

        public Editor build() {
            return new Editor(
                    this.id,
                    this.nome,
                    this.email,
                    this.valorPagoPorPalavra,
                    this.premium
            );
        }
    }
}
