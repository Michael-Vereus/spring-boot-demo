package com.example.demo.helper;


import java.util.HashMap;
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
    public static DebugHelp fail(String msg){
        DebugHelp debugHelp = new DebugHelp();
        debugHelp.addDebug("Err", msg);
        return debugHelp;
    }
}

// read this when u come back here add getter setter here for item receiving incoming dto okay?
