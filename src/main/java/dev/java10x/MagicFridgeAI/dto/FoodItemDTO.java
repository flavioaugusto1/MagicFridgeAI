package dev.java10x.MagicFridgeAI.dto;

import java.time.LocalDate;

public class FoodItemDTO {
    private Long id;
    private String name;
    private String category;
    private Integer quantity;
    private LocalDate expiration_date;

    public FoodItemDTO() {
    }

    public FoodItemDTO(Long id, String name, String category, Integer quantity, LocalDate expiration_date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.expiration_date = expiration_date;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }
}
