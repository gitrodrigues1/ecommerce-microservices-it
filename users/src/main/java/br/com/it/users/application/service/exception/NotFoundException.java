package br.com.it.users.application.service.exception;

public class NotFoundException extends RuntimeException{ 
    
    public NotFoundException() {
        super("Resource not found.");
    }
}
