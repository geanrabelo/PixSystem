package com.br.core.exceptions;

public class UserIdNotExists extends RuntimeException{
    public UserIdNotExists(String message){
        super(message);
    }
}
