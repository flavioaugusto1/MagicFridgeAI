package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeminiService {

    private final WebClient webClient;
    private String apiKey = System.getenv("API_KEY_GEMINI");

    public GeminiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> generateRecepi(List<FoodItemDTO> foodItemDTOList){
        String foods = foodItemDTOList.stream()
                .map(item -> String.format("$s (%s) - Quantidade: $s - Validade: $s",
                        item.getName(),item.getCategory(), item.getQuantity(), item.getExpiration_date()))
                .collect(Collectors.joining("\n"));


        String prompt = "Você é um chefe e vai me sugerir uma receita baseado nos ingredientes que vou te passar" + foods;

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of(
                                "parts", List.of(
                                        Map.of(
                                                "text", prompt
                                        )
                                )
                        )
                )
        );

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("x-goog-api-key", apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var candidates = (List<Map<String, Object>>) response.get("candidates");

                    if(candidates != null && !candidates.isEmpty()){
                        var content = (Map<String, Object>) candidates.get(0).get("content");
                        var parts = (List<Map<String, Object>>) content.get("parts");

                        return parts.get(0).get("text").toString();
                    }

                    return "Nenhuma receita foi gerada";
                });
    }
}
