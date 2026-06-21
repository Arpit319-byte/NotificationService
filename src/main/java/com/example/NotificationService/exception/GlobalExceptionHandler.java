package com.example.NotificationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.NotificationService.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> ResourceNotFoundException(ResourceNotFoundException ex){
         
        ErrorResponse errorResponse=new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(InvalidNotificationStateException.class)
    public ResponseEntity<ErrorResponse> InvalidNotificationStateException(InvalidNotificationStateException ex){

        ErrorResponse error= new ErrorResponse(
              HttpStatus.BAD_REQUEST.value(),
              ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }


    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> DuplicateResourceException(DuplicateResourceException ex){

        ErrorResponse error= new ErrorResponse(
            HttpStatus.CONFLICT.value(),
            ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
    
}
