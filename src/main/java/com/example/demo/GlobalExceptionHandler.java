package com.example.demo;

import com.example.demo.helper.DebugHelp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // Global Exception Handler :o, i saw this one from the spring.io blog
    public DebugHelp<String> handleGeneralException(Exception e){
        DebugHelp<String> debugHelp = new DebugHelp<String>();
        debugHelp.addDebug("An Unexpected Error occured : ", e.getMessage());
        return debugHelp;
    }

    // i got this code from gemini so lets try it out
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<DebugHelp<String>> handleNotFound(NoHandlerFoundException e) {
        DebugHelp<String> debugHelp = new DebugHelp<>();
        debugHelp.addDebug("Route Error", "The path " + e.getRequestURL() + " does not exist.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(debugHelp);
    }
}
