package com.br.core.enums;

public enum EnumCode {
    USR0000("User error - User find by id not found"),
    USR0001("User error - CPF or EMAIL already exists in database"),
    ACC0000("Account error - Account find by id not found"),
    ACC0001("Account error - Account find by number already exists"),
    ACC0002("Account error -Account not have balance enough for transaction"),
    PXK0000("Pix Key error - Pix Key find by id not found"),
    PXK0001("Pix Key error - This keyValue already exists in database"),
    PXK0002("Pix key error - This keyValue not exists"),
    PXK0003("Pix key error - This pix key not active"),
    TRS0000("Transaction error - Transaction find by id not found"),
    SLT0000("Settlement error - Settlement find by id not found"),
    REF0000("Refund error - The refund has already been processed"),
    REF0001("Refund error - The refund find by id not found");



    private String message;

    EnumCode(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
