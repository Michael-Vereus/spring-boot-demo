package com.example.demo.helper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DebugHelp<T> {
    private Map<String, T> debughere ;

    public DebugHelp(){
        this.debughere = new HashMap<>();
    }

    public void addDebug(String key, T t){
        this.debughere.put(key, t);
    }
    public Map<String, T> getDebughere(){
        return this.debughere;
    }
    public static DebugHelp debug (){
        return new DebugHelp();
    }
}
