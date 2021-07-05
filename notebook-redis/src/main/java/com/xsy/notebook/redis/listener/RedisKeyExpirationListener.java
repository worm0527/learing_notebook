package com.xsy.notebook.redis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * 监听redis key过期事件，需要开启redis.cong配置文件中 `notify-keyspace-events Ex`配置
 *
 * @author shuyuan.xu
 * @date 2020-11-29.
 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

  public RedisKeyExpirationListener(
      RedisMessageListenerContainer listenerContainer) {
    super(listenerContainer);
  }

  @Override
  public void onMessage(Message message, byte[] pattern) {
    String expiredKey = message.toString();
    System.out.println("监听到key：" + expiredKey + "已过期");
  }
}
