package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;

import java.math.BigDecimal;

public class EditorTestData {

    private EditorTestData() {

    }

    public static Editor.Builder umEditorNovo() {
        return Editor.builder()
                .comNome("Alex")
                .comEmail("alex@email.com")
                .comValorPagoPorPalavra(BigDecimal.TEN)
                .comPremium(true);
    }

    public static Editor.Builder umEditorExistente() {
        return umEditorNovo().comId(1L);
    }

    public static Editor.Builder umEditorComIdInexistente() {
        return umEditorNovo().comId(99L);
    }

}
