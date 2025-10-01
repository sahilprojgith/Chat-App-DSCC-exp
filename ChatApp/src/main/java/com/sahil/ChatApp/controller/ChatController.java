package com.sahil.ChatApp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahil.ChatApp.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @Autowired
    private ObjectMapper objectMapper;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public String sendMessage(ChatMessage message) throws Exception {
        return objectMapper.writeValueAsString(message);
    }

    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }


}
