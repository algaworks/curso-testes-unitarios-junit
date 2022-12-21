package com.algaworks.junit.blog.exception;

public class RegraNegocioException extends RuntimeException {

    public RegraNegocioException() {
    }

    public RegraNegocioException(String message) {
        super(message);
    }
}
