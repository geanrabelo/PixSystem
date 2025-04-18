package com.br.core.exceptions;

public class AccountNumberAlreadyExists extends RuntimeException {
    public AccountNumberAlreadyExists(String message) {
        super(message);
    }
}
