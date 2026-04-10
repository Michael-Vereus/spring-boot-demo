package com.example.demo.repository;

import com.example.demo.helper.Utility;
import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<Item, Long> {
    default  String test(){return "Ok Repository is alive : " + this.toString();}

    @Modifying // To basically modify a query
    @Query("DELETE FROM Item i where i.id IN :ids") // the query u want
    int deleteByIdIn(@Param("ids") List<Long> ids); // told the JPA to return the rows affecteed in this case how many rows deleted
}
