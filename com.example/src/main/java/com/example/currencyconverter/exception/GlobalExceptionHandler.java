/*
 * package com.example.currencyconverter.exception;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.bind.annotation.RestControllerAdvice;
 * 
 * @RestControllerAdvice public class GlobalExceptionHandler {
 * 
 * @ExceptionHandler(Exception.class) public ResponseEntity<String>
 * handleException(Exception e) { return new ResponseEntity<String>("Error: " +
 * e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * @ExceptionHandler(IllegalArgumentException.class) public
 * ResponseEntity<String>
 * handleIllegalArgumentException(IllegalArgumentException e) { return new
 * ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); } }
 */