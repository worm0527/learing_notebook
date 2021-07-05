package com.xsy.notebook.redis.config;

import com.xsy.notebook.redis.handler.WebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author shuyuan.xu
 * @date 2020-10-31.
 */
@Configuration
@EnableWebSocket
public class SocketConfig {

  @Bean
  public WebSocketConfigurer webSocketConfig(WebSocketHandler socketHandler) {
    return registry -> {
      registry.addHandler(socketHandler, "/ws/socket").setAllowedOrigins("*");
    };
  }

}
