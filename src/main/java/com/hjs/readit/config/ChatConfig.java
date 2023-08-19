package com.hjs.readit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.hjs.readit.handler.ChatHandler;

@Configuration
@EnableWebSocket
public class ChatConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new ChatHandler(), "/user")
                .setAllowedOrigins("*")
                .withSockJS();
        
        System.out.println("소켓 핸들러 생성 완료");
    }
}