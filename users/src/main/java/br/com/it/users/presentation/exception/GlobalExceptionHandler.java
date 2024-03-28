package br.com.it.users.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.it.users.application.service.exception.BusinessException;
import br.com.it.users.application.service.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
