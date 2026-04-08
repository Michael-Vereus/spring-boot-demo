package com.example.demo;

import com.example.demo.dto.DemoResponse;
import com.example.demo.model.Item;
import com.example.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("ALL")
@RestController
public class TestController {
    @Autowired
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
    public DemoResponse<String> test(){
        return DemoResponse.debug(demoService.test());
    }

    @GetMapping("/testSQLdb")
    public DemoResponse testALl(){
        System.out.println(demoService.testAll());
        Map<String, List<Item>> testDb = new HashMap<>();
        testDb.put("Result", demoService.testAll());
        return DemoResponse.debug(testDb);
    }

    @GetMapping("/get/{id}")
    public DemoResponse search(@PathVariable Long id){
        Map<String, Optional<Item>> itemFound = new HashMap<>();
        itemFound.put("Result", demoService.searchById(id));
        return  DemoResponse.debug(itemFound);
    }
}
