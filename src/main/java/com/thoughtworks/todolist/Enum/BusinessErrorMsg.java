package com.thoughtworks.todolist.Enum;

public enum BusinessErrorMsg {

    PARAM_ILLEGAL("已有该记录，不允许重复添加");

    private String message;

    BusinessErrorMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
