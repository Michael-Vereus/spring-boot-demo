package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

@JsonPropertyOrder({"status","msg","responseDebug"})
public class DemoResponse<T> {
    private boolean status;
    private String msg;
    private Map<String, T> responseDebug;

    public DemoResponse(boolean status, String msg){
        this.status = status;
        this.msg = msg;
    }
    public DemoResponse(boolean status, Map<String, T> responseDebug){
        this.status = status;
        this.responseDebug = responseDebug;
    }

    public DemoResponse(boolean status, String msg, Map<String, T> responseDebug){
        this.responseDebug = responseDebug;
        this.msg = msg;
        this.status = status;
    }

    // public getter fox jackson converting this to JSON.
    public String getMsg() { return this.msg;}
    public boolean getStatus() {return this.status;}
    public Map<String, T> getResponseDebug() { return this.responseDebug;}

    // static function to return certain status
    public static <T> DemoResponse<T> sucess(String message){
        return new DemoResponse(true, message);
    }
    public static <T> DemoResponse<T> debug(Map<String, T> responseDebug){
        return new DemoResponse(true, responseDebug);
    }

}
