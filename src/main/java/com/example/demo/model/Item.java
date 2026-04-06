package com.example.demo.model;
import jakarta.persistence.*;

@Entity // This tells Spring: "Make a table out of this"
@Table(name = "items")
public class Item {

    @Id // The Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    private String name;
    private Double price;

    // IMPORTANT: You must have a default constructor,
    // and Getters/Setters for Spring to work!
    public Item() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}