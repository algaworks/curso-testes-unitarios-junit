package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

    @Test
    void deveEsperarENaoDarTimeout() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }
}