package com.yarvin.tasklist.exceptions;

import com.yarvin.tasklist.dto.ErrorDto;
import com.yarvin.tasklist.dto.ErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = TaskControllerExceptionHandler.class)
public class ApiExceptionHandler {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleCreationException(TaskNotFoundException exception) {
        var error = ErrorDto.builder()
                .message(exception.getMessage())
                .build();

        var result = new ErrorResponseDto().setError(error);

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(result);
    }
    @ExceptionHandler(TaskByIdException.class)
    public ResponseEntity<ErrorResponseDto> handleCreationException(TaskByIdException exception) {
        var error = ErrorDto.builder()
                .message(exception.getMessage())
                .build();

        var result = new ErrorResponseDto().setError(error);

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(result);
    }

    @ExceptionHandler(TaskCreateException.class)
    public ResponseEntity<ErrorResponseDto> handleCreationException( TaskCreateException exception) {
        var error = ErrorDto.builder()
                .message(exception.getMessage())
                .build();

        var result = new ErrorResponseDto().setError(error);

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(result);
    }

    @ExceptionHandler(TaskPutException.class)
    public ResponseEntity<ErrorResponseDto> handleCreationException(TaskPutException exception) {
        var error = ErrorDto.builder()
                .message(exception.getMessage())
                .build();

        var result = new ErrorResponseDto().setError(error);

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(result);
    }
}
