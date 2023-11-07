package com.yarvin.tasklist.exceptions;

public class ExistException extends RuntimeException{
    public ExistException (String message){
        super(message);
    }
    public static final String TASK_EXIST = "Поле текста пусто";
}
