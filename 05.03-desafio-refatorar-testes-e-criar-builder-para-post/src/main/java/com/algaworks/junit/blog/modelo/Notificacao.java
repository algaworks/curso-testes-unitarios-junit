package com.algaworks.junit.blog.modelo;

import java.time.OffsetDateTime;

public class Notificacao {
    private OffsetDateTime offsetDateTime;
    private String conteudo;

    public Notificacao(OffsetDateTime offsetDateTime, String conteudo) {
        this.offsetDateTime = offsetDateTime;
        this.conteudo = conteudo;
    }

    public OffsetDateTime getOffsetDateTime() {
        return offsetDateTime;
    }

    public void setOffsetDateTime(OffsetDateTime offsetDateTime) {
        this.offsetDateTime = offsetDateTime;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
