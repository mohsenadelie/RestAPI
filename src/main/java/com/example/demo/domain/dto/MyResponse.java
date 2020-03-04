package com.example.demo.domain.dto;

public class MyResponse {
    private Object body;
    private String errorMessage;

    @Override
    public String toString() {
        return "MyResponse{" +
                "message='" + body + '\'' +
                ", error='" + errorMessage + '\'' +
                '}';
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
