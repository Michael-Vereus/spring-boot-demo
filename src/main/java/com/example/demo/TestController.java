package com.example.demo;

import com.example.demo.dto.DemoResponse;
import com.example.demo.services.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private DemoService demoService;

    public TestController(DemoService demoService){
        this.demoService = demoService;
    }
    @GetMapping("/welcome")
    public String sayHello() {
        return "Server is Up and Running \n";
    }
    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable String msg){
        return "You whispered : " + msg + "\n";
    }
    @GetMapping("/test")
    public String test(){
        return demoService.test();
    }

    @GetMapping("/demoReturn")
    public DemoResponse returnDemo(){
        return new DemoResponse(true, "Test Jackson hee hee");
    }
}
