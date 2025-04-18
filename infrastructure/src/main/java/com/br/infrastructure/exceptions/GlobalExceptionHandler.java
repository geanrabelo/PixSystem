package com.br.infrastructure.exceptions;

import com.br.core.exceptions.*;
import com.br.infrastructure.exceptions.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserIdNotExists.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userIdNotExistsHandler(UserIdNotExists userIdNotExists){
        return ErrorResponse.notFound(userIdNotExists.getMessage());
    }

    @ExceptionHandler(UserNotValid.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse userNotValidHanlder(UserNotValid userNotValid){
        return ErrorResponse.invalid(userNotValid.getMessage());
    }

    @ExceptionHandler(AccountNumberAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse accountNumberAlreadyExistsHandler(AccountNumberAlreadyExists accountNumberAlreadyExists){
        return ErrorResponse.conflict(accountNumberAlreadyExists.getMessage());
    }

    @ExceptionHandler(AccountIdNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse accountIdNotFoundHandler(AccountIdNotFound accountIdNotFound){
        return ErrorResponse.notFound(accountIdNotFound.getMessage());
    }

    @ExceptionHandler(PixKeyValueAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse pixKeyValueAlreadyExistsHandler(PixKeyValueAlreadyExists pixKeyValueAlreadyExists){
        return ErrorResponse.conflict(pixKeyValueAlreadyExists.getMessage());
    }

    @ExceptionHandler(PixKeyIdNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse pixKeyIdNotFoundHandler(PixKeyIdNotFound pixKeyIdNotFound){
        return ErrorResponse.notFound(pixKeyIdNotFound.getMessage());
    }

    @ExceptionHandler(PixKeyReceiverNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse pixKeyReceiverNotFoundHandler(PixKeyReceiverNotFound pixKeyReceiverNotFound){
        return ErrorResponse.notFound(pixKeyReceiverNotFound.getMessage());
    }
}
