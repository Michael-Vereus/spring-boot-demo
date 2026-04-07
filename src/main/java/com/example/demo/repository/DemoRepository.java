package com.example.demo.repository;

import com.example.demo.helper.Utility;
import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<Item, Long> {
    default  String test(){return "Ok Repository is alive : " + this.toString();}
}
