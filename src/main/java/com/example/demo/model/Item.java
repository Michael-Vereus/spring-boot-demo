package com.example.demo.model;
import com.example.demo.dto.Item.CreateItem;
import jakarta.persistence.*;

@Entity // This tells Spring: "Make a table out of this"
@Table(name = "items")
public class Item {

    @Id // The Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    private String name;
    private Double price;

    public Item(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item(CreateItem createItem){
        this.id = createItem.getId();
        this.name = createItem.getName();
        this.price = createItem.getPrice();
    }

    // DEFAULT CONSTRUCTOR for SPRING to WORK
    public Item(){}

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }

    // removed some unused setter
}