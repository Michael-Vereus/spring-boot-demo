package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/welcome")
    public String sayHello() {
        return "Server is Up and Running \n";
    }
    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable String msg){
        return "You whispered : " + msg + "\n";
    }
}
