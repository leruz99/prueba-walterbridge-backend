package org.pruebatecnica.exceptions;


import org.pruebatecnica.domain.dto.CreateTaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<CreateTaskResponse<Object>> handleTaskNotFoundException(TaskNotFoundException ex) {
        return new ResponseEntity<>(buildResponseException(ex), HttpStatus.NOT_FOUND);
    }
    private CreateTaskResponse<Object> buildResponseException(TaskNotFoundException ex) {
        CreateTaskResponse<Object> response = new CreateTaskResponse<>();
        response.setMessage(ex.getMessage());
        return response;
    }
}
