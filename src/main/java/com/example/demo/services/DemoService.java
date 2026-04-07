package com.example.demo.services;


import com.example.demo.model.Item;
import com.example.demo.repository.DemoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoService {
    private DemoRepository demoRepository;

    public DemoService(DemoRepository demoRepository){
        this.demoRepository = demoRepository;
    }
    public Map<String, String> test(){
        Map<String, String> response = new HashMap<>();
        response.put("Service", this.toString());
        response.put("Repository", demoRepository.test());
        return response;
    }
    public List<Item> testAll(){
        List<Item> testAll = demoRepository.findAll();
        return testAll;
    }
}
