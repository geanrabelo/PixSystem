package com.br.core.exceptions;

public class RefundHasAlreadyBeenProcessed extends RuntimeException {
    public RefundHasAlreadyBeenProcessed(String message) {
        super(message);
    }
}
