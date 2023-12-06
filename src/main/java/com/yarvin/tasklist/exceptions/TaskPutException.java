package com.yarvin.tasklist.exceptions;

import org.springframework.http.HttpStatus;

public class TaskPutException extends ApiException{
    public TaskPutException(String message){
        super(HttpStatus.BAD_REQUEST, message);
    }
}
