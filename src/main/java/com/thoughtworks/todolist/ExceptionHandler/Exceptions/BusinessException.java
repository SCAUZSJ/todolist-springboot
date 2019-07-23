package com.thoughtworks.todolist.ExceptionHandler.Exceptions;

public class BusinessException extends  RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
