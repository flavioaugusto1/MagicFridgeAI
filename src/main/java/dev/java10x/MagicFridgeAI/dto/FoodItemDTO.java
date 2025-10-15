package dev.java10x.MagicFridgeAI.dto;

import dev.java10x.MagicFridgeAI.enums.CategoryFoodItem;

import java.time.LocalDate;

public class FoodItemDTO {
    private Long id;
    private String name;
    private CategoryFoodItem category;
    private Integer quantity;
    private LocalDate expirationDate;

    public FoodItemDTO() {
    }

    public FoodItemDTO(Long id, String name, CategoryFoodItem category, Integer quantity, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryFoodItem getCategory() {
        return category;
    }

    public void setCategory(CategoryFoodItem category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
