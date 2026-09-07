package com.est_jpa.estudo_jpa.common.Exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice 
public class ResourceExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
            StandardError err = new StandardError();
            err.setStatus(404);
            err.setMessage(e.getMessage());
            err.setPath(request.getRequestURI());
            return ResponseEntity.status(404).body(err);
        }

        @ExceptionHandler(DatabaseException.class)
	    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		    String error = "Database error";
		    HttpStatus status = HttpStatus.BAD_REQUEST;
		    StandardError err = new StandardError();
		    err.setStatus(status.value());
		    err.setMessage(e.getMessage());
		    err.setPath(request.getRequestURI());
		    return ResponseEntity.status(status).body(err);
	}
}
