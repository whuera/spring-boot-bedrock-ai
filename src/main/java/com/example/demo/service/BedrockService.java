package com.example.demo.service;

import org.springframework.ai.bedrock.converse.BedrockConverseClient;
import org.springframework.ai.bedrock.converse.BedrockConverseChatClient;
import org.springframework.ai.bedrock.embedding.BedrockEmbeddingClient;
import org.springframework.ai.bedrock.image.BedrockImageClient;
import org.springframework.ai.bedrock.moderation.BedrockModerationClient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BedrockService {

    private final BedrockConverseClient converseClient;
    private final BedrockConverseChatClient chatClient;
    private final BedrockEmbeddingClient embeddingClient;
    private final BedrockImageClient imageClient;
    private final BedrockModerationClient moderationClient;

    public BedrockService(
            BedrockConverseClient converseClient,
            BedrockConverseChatClient chatClient,
            BedrockEmbeddingClient embeddingClient,
            BedrockImageClient imageClient,
            BedrockModerationClient moderationClient) {
        this.converseClient = converseClient;
        this.chatClient = chatClient;
        this.embeddingClient = embeddingClient;
        this.imageClient = imageClient;
        this.moderationClient = moderationClient;
    }

    public String generateText(String prompt) {
        return converseClient.generate(prompt).getContent();
    }

    public String chat(String message) {
        return chatClient.generate(message).getContent();
    }

    public List<Double> getEmbedding(String text) {
        return embeddingClient.embed(text).getData();
    }

    public String generateImage(String prompt) {
        return imageClient.generate(prompt).getContent();
    }

    public boolean moderateContent(String text) {
        return moderationClient.moderate(text).isFlagged();
    }
}