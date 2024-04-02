package com.example.kbrah.Advice;

import com.example.kbrah.ApiExiption.ApiExcipstion;
import com.example.kbrah.ApiExiption.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(value = ApiExcipstion.class)
    public ResponseEntity ApiExpception(ApiExcipstion e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(massege);
    }



    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException (HttpRequestMethodNotSupportedException e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(massege);
    }


    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(massege);
    }


    @ExceptionHandler(value =  MethodArgumentNotValidException.class )
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(massege);
    }


    @ExceptionHandler(value = DataIntegrityViolationException.class)

    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(massege);
    }


    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(massege);
    }


    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(massege);
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResponseEntity HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(massege);
    }


    @ExceptionHandler(value =TransactionSystemException.class)
    public ResponseEntity TransactionSystemException(TransactionSystemException e){
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }
}
