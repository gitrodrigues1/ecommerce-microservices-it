package br.com.it.users.application.service.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
