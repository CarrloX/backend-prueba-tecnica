package com.ejemplo.demo.utils.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Credenciales inválidas";

    public InvalidCredentialsException() {
        super(ERROR_MESSAGE);
    }
}
