package com.ltp.contacts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.exception.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {


  @ExceptionHandler(ContactNotFoundException.class)
  public ResponseEntity<Object> handleContactNotFoundException(ContactNotFoundException ex) {
    ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());  
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
  
}

    
