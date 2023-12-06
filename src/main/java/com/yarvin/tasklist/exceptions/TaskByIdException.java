package com.yarvin.tasklist.exceptions;

import org.springframework.http.HttpStatus;

public class TaskByIdException extends ApiException {

    public TaskByIdException (String message){
        super(HttpStatus.BAD_REQUEST,message);
    }
}
