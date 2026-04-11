package com.example.demo.dto.Item;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class CreateItem {
    @Null(message = "Id field must be empty.")
    private Long id;

    @NotEmpty(message = "Name field can't be empty")
    private String name;

    @NotNull(message = "Price field can't be empty")
    @DecimalMin(value = "0.01", message = "The price must be at least 0.01 .")
    private Double price;

    // getter
    public Double getPrice() {
        return price;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
