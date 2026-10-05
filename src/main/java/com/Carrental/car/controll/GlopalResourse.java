package com.Carrental.car.controll;

import com.Carrental.car.Exaption.ErrorREsponse;
import com.Carrental.car.Exaption.ErrorREsponseExaption;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlopalResourse {
    @ExceptionHandler(ErrorREsponseExaption.class)
    @ResponseBody
    public ResponseEntity<?> handleerror(ErrorREsponseExaption errorREsponseExaption) {
        ErrorREsponse errorREsponse = new ErrorREsponse(errorREsponseExaption.getMessage(),LocalDateTime.now(),404);

        return new ResponseEntity<>(errorREsponse,HttpStatus.NOT_FOUND);

    }

}