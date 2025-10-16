package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {
    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<FoodItemDTO> createFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItem = foodItemService.createFoodItem(foodItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodItem);
    }

    @GetMapping("/list")
    public ResponseEntity<List<FoodItemDTO>> listAllFoodItem(){
        List<FoodItemDTO> foodItemDTOList = foodItemService.listAllFoodItems();
        return ResponseEntity.ok(foodItemDTOList);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listFoodItemById(@PathVariable Long id){
        FoodItemDTO foodItemById = foodItemService.listFoodItemById(id);

        if(foodItemById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comida não encontrada");
        }

        return ResponseEntity.ok(foodItemById);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFoodItem(
            @PathVariable Long id,
            @RequestBody FoodItemDTO foodItemDTO
    ){
        FoodItemDTO foodItemById = foodItemService.listFoodItemById(id);

        if(foodItemById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Comida não encontrada"));
        }

        FoodItemDTO foodItemUpdated = foodItemService.updateFoodItem(id, foodItemDTO);

        return ResponseEntity.ok(foodItemUpdated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFoodItem(
            @PathVariable Long id
    ){
        FoodItemDTO foodItemById = foodItemService.listFoodItemById(id);

        if(foodItemById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Comida não encontrada"));
        }

        foodItemService.deleteFoodItem(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado com sucesso");
    }

}
