package com.algaworks.junit.blog.negocio;

public class Mensagem {
    private String destinatario;
    private String assunto;
    private String conteudo;

    public Mensagem(String destinatario, String assunto, String conteudo) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
