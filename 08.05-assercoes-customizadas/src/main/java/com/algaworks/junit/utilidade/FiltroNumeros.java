package com.algaworks.junit.utilidade;

import java.util.ArrayList;
import java.util.List;

public class FiltroNumeros {

    private FiltroNumeros() {

    }

    public static List<Integer> numerosPares(List<Integer> numeros) {
        return new ArrayList<>(numeros).stream().filter(numero -> numero % 2 == 0).toList();
    }

    public static List<Integer> numerosImpares(List<Integer> numeros) {
        return new ArrayList<>(numeros).stream().filter(numero -> numero % 2 != 0).toList();
    }

    public static boolean isPositivo(int numero) {
        return numero >= 0;
    }

}
