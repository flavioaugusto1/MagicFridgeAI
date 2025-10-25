package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import dev.java10x.MagicFridgeAI.service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RecepiController {

    private final GeminiService geminiService;
    private final FoodItemService foodItemService;

    public RecepiController(GeminiService geminiService, FoodItemService foodItemService) {
        this.geminiService = geminiService;
        this.foodItemService = foodItemService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateRecepi(){
        List<FoodItemDTO> foodItemDTOList = foodItemService.listAllFoodItems();

        return geminiService.generateRecepi(foodItemDTOList)
                .map(recipe -> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
