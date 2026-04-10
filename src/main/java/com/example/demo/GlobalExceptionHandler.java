package com.example.demo;

import com.example.demo.helper.DebugHelp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // Global Exception Handler :o, i saw this one from the spring.io blog
    public DebugHelp<String> handleGeneralException(Exception e){
        DebugHelp<String> debugHelp = new DebugHelp<String>();
        debugHelp.addDebug("An Unexpected Error occured : ", e.getMessage());
        return debugHelp;
    }
}
