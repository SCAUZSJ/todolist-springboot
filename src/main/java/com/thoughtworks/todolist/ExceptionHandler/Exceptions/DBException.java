package com.thoughtworks.todolist.ExceptionHandler.Exceptions;

public class DBException extends RuntimeException {

    public DBException(String message) {
        super(message);
    }
}
