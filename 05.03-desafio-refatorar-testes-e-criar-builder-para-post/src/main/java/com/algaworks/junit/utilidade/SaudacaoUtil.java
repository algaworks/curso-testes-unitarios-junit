package com.algaworks.junit.utilidade;

public class SaudacaoUtil {

    private SaudacaoUtil() {
        
    }

    public static String saudar(int hora) {
        if (hora >= 5 && hora <= 11) {
            return "Bom dia";
        } else if(hora >= 12 && hora <= 17) {
            return "Boa tarde";
        } else if(hora >= 18 && hora <= 23 || hora >= 0 && hora < 5) {
            return "Boa noite";
        }
        throw new IllegalArgumentException("Hora inválida");
    }

}
