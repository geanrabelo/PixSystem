package com.br.core.exceptions;

public class UserNotValid extends RuntimeException {
    public UserNotValid(String message) {
        super(message);
    }
}
