package com.xsy.notebook.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * redis回调config
 * @author shuyuan.xu
 * @date 2020-11-29.
 */
@Configuration
public class RedisLinstenerConfig {

  @Bean
  public RedisMessageListenerContainer listenerContainer(RedisConnectionFactory connectionFactory) {
    RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
    listenerContainer.setConnectionFactory(connectionFactory);
    return listenerContainer;
  }

}
