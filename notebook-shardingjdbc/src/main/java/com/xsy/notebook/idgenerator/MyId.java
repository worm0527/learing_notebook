package com.xsy.notebook.idgenerator;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

/**
 * @author shuyuan.xu, <shuyuan.xu@leyantech.com>
 * @date 2020-08-17.
 */
public class MyId implements ShardingKeyGenerator {

  private ShardingKeyGenerator keyGenerator = new SnowflakeShardingKeyGenerator();

  @Override
  public Comparable<?> generateKey() {
    System.out.println("call my generateKey");
    return keyGenerator.generateKey();
  }

  @Override
  public String getType() {
    return "MYID";
  }

  @Override
  public Properties getProperties() {
    return null;
  }

  @Override
  public void setProperties(Properties properties) {

  }
}
