package sena.com.back_end_game.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Ocurrió un error inesperado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Manejo de excepciones de entidad no encontrada
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException e) {
        return new ResponseEntity<>("Entidad no encontrada: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Manejo de excepciones de datos no válidos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleInvalidData(MethodArgumentNotValidException e) {
        return new ResponseEntity<>("Datos inválidos: " + e.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}

