package com.br.core.exceptions;

public class TransactionIdNotFound extends RuntimeException {
    public TransactionIdNotFound(String message) {
        super(message);
    }
}
