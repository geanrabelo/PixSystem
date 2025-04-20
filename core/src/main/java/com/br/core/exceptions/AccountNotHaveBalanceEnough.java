package com.br.core.exceptions;

public class AccountNotHaveBalanceEnough extends RuntimeException {
    public AccountNotHaveBalanceEnough(String message) {
        super(message);
    }
}
