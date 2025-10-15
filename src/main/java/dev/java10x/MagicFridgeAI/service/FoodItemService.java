package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.mapper.FoodItemMapper;
import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {
    private FoodItemRepository foodItemRepository;
    private FoodItemMapper foodItemMapper;

    public FoodItemService(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
    }

    public FoodItemDTO createFoodItem(FoodItemDTO foodItemDTO){
        FoodItem foodItem = foodItemMapper.map(foodItemDTO);
        foodItemRepository.save(foodItem);
        return foodItemMapper.map(foodItem);
    }

    public List<FoodItemDTO> listAllFoodItems(){
        List<FoodItem> foodItem = foodItemRepository.findAll();
        return foodItem.stream().map(foodItemMapper::map).toList();
    }

    public FoodItemDTO listFoodItemById(Long id){
        Optional<FoodItem> foodItem = foodItemRepository.findById(id);
        return foodItem.map(foodItemMapper::map).orElse(null);
    }

    public FoodItemDTO updateFoodItem(Long id, FoodItemDTO foodItemDTO){
        Optional<FoodItem> foodItem = foodItemRepository.findById(id);

        if(foodItem.isPresent()){
           FoodItem food = foodItemMapper.map(foodItemDTO);
           food.setId(id);
           foodItemRepository.save(food);
           return foodItemMapper.map(food);
        }

        return null;
    }

    public void deleteFoodItem(Long id){
        foodItemRepository.deleteById(id);
    }
}
