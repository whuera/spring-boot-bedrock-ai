package com.example.demo.controller;

import com.example.demo.service.BedrockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bedrock")
public class BedrockController {

    private final BedrockService bedrockService;

    public BedrockController(BedrockService bedrockService) {
        this.bedrockService = bedrockService;
    }

    /**
     * Generate text using BedrockConverseClient
     */
    @GetMapping("/generate")
    public String generateText(@RequestParam String prompt) {
        return bedrockService.generateText(prompt);
    }

    /**
     * Chat with BedrockConverseChatClient
     */
    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return bedrockService.chat(message);
    }

    /**
     * Get text embeddings using BedrockEmbeddingClient
     */
    @GetMapping("/embedding")
    public List<Double> getEmbedding(@RequestParam String text) {
        return bedrockService.getEmbedding(text);
    }

    /**
     * Generate an image using BedrockImageClient
     */
    @GetMapping("/image")
    public String generateImage(@RequestParam String prompt) {
        return bedrockService.generateImage(prompt);
    }

    /**
     * Moderate content using BedrockModerationClient
     */
    @GetMapping("/moderate")
    public boolean moderateContent(@RequestParam String text) {
        return bedrockService.moderateContent(text);
    }
}