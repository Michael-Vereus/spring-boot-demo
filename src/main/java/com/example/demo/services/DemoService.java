package com.example.demo.services;

import com.example.demo.repository.DemoRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private DemoRepository demoRepository;

    public DemoService(){
        this.demoRepository = new DemoRepository();
    }
    public String test(){
        StringBuilder sb = new StringBuilder();
        sb.append("Test From Services : ")
                .append(this.toString())
                .append("\n")
                .append("Repository : ")
                .append(demoRepository.test())
                .append("\n");
        return sb.toString();
    }
}
