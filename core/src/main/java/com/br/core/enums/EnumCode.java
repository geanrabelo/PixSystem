package com.br.core.enums;

public enum EnumCode {
    USR0000("User find by id not found"),
    USR0001("User invalid - CPF or EMAIL already exists in database"),
    ACC0000("Account find by id not found"),
    ACC0001("Account find by number already exists"),
    PXK0000("Pix Key find by id not found"),
    PXK0001("Pix Key invalid - This keyValue already exists in database"),
    PXK0002("Pix key value invalid - This keyValue not exists");



    private String message;

    EnumCode(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
