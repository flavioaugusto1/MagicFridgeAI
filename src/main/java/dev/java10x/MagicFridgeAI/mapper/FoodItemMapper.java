package dev.java10x.MagicFridgeAI.mapper;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.model.FoodItem;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {
    public FoodItem map(FoodItemDTO foodItemDTO){
        FoodItem foodItem = new FoodItem();
        foodItem.setId(foodItemDTO.getId());
        foodItem.setName(foodItemDTO.getName());
        foodItem.setCategory(foodItemDTO.getCategory());
        foodItem.setQuantity(foodItemDTO.getQuantity());
        foodItem.setExpiration_date(foodItemDTO.getExpiration_date());

        return foodItem;
    }

    public FoodItemDTO map(FoodItem foodItem){
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        foodItemDTO.setId(foodItem.getId());
        foodItemDTO.setName(foodItem.getName());
        foodItemDTO.setCategory(foodItem.getCategory());
        foodItemDTO.setQuantity(foodItem.getQuantity());
        foodItemDTO.setExpiration_date(foodItem.getExpiration_date());

        return foodItemDTO;
    }
}
