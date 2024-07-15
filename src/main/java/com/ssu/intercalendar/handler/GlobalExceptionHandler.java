package com.ssu.intercalendar.handler;

import com.ssu.intercalendar.exception.NotFoundGroupException;
import com.ssu.intercalendar.exception.NotFoundScheduleException;
import com.ssu.intercalendar.exception.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundScheduleException.class)
    public ResponseEntity<String> handlerNotFoundScheduleException(NotFoundScheduleException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<String> handlerNotFoundUserException(NotFoundUserException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(NotFoundGroupException.class)
    public ResponseEntity<String> handlerNotFoundGroupException(NotFoundGroupException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
