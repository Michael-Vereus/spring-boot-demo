package com.example.demo.services;


import com.example.demo.model.Item;
import com.example.demo.repository.DemoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Optional<Item> searchById(Long id){
        Optional<Item> itemFound = demoRepository.findById(id);
        return itemFound;
    }
//    public void deleteById(){
//
//        demoRepository.deleteAllById();
//    }
//    public String checkVer(){
//        demoRepository.hashCode()
//    }
}
