package com.example.demo.services;


import com.example.demo.model.Item;
import com.example.demo.repository.DemoRepository;
import jakarta.transaction.Transactional;
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
    @Transactional // turns out this shi is literally telling the system on how to do this stuff, so dont delete annotation super important
    public String deleteById(List<Long> listOdId){
        int affectedRows = demoRepository.deleteByIdIn(listOdId); // List class already implements Iterable
//        demoRepository.deleteAllById(listOdId);
        if(affectedRows > 0){
            return "Successfully Deleted";
        }else{
            return "No such Item exists with that ID";
        }
    }
//    public String checkVer(){
//        demoRepository.hashCode()
//    }
}
