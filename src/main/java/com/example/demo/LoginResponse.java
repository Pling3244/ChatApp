package com.example.demo;

public class LoginResponse {
    private String message;
    private String token;
    // 추가적인 필드들을 필요에 따라 선언할 수 있습니다

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // 추가적인 getter와 setter 메소드들을 필요에 따라 선언할 수 있습니다
}

