package com.me.carsite.exceptions;

import com.me.carsite.models.Car;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @NotNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NotNull HttpHeaders headers,
                                                                  @NotNull HttpStatus status,
                                                                  @NotNull WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CarNotFoundException.class)
    private ResponseEntity<ExceptionResponse> carNotFoundExceptions(Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), exception.getMessage(), "404");

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SellerNotFoundException.class)
    private ResponseEntity<ExceptionResponse> sellerNotFoundExceptions(Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), exception.getMessage(), "404");

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarAdvertisementNotFoundException.class)
    private ResponseEntity<ExceptionResponse> carAdvertisementNotFoundExceptions(Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), exception.getMessage(), "404");

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
