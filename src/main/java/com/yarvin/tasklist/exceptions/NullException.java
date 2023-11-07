package com.yarvin.tasklist.exceptions;

public class NullException extends RuntimeException{
    public  NullException(Long id){
        super( "Задачи с id " + id + " не существует");
    }
    public NullException(String message) {
        super(message);
    }

    public static final String NULL_TEXT = "Поле текста пусто";
    public static final String NULL_TITLE = "Поле заголовка пусто";


}
