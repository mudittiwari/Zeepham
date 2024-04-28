package com.mudit.zeepham.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler{
    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<String> objectNotFoundException(ObjectNotFound exception,
			HttpServletRequest request){
                return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
    
}
