package com.br.core.exceptions;

public class AccountIdNotFound extends RuntimeException {
    public AccountIdNotFound(String message) {
        super(message);
    }
}
