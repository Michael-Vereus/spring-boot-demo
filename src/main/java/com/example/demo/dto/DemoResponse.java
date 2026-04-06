package com.example.demo.dto;

public class DemoResponse {
    private boolean status;
    private String msg;

    public DemoResponse(boolean status, String msg){
        this.status = status;
        this.msg = msg;
    }

    public String getMsg() { return this.msg;}
    public boolean getStatus() {return this.status;}
}
