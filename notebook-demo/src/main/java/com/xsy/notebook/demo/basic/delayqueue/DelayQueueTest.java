package com.xsy.notebook.demo.basic.delayqueue;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * JDK DelayQueue
 *
 * @author shuyuan.xu
 * @date 2020-11-29.
 */
public class DelayQueueTest {

  public static void main(String[] args) {
    Order order1 = new Order("订单1", 5, TimeUnit.SECONDS);
    Order order2 = new Order("订单2", 10, TimeUnit.SECONDS);
    Order order3 = new Order("订单3", 15, TimeUnit.SECONDS);

    DelayQueue<Order> delayQueue = new DelayQueue<>();
    delayQueue.add(order1);
    delayQueue.add(order2);
    delayQueue.add(order3);

    System.out.println("开始时间：" + LocalDateTime.now());
    while (!delayQueue.isEmpty()) {
      Order order = delayQueue.poll();
      if (order != null) {
        System.out.println(String.format("订单名称：%s 取消时间：%s", order.getName(), LocalDateTime.now()));
      }
    }
  }

}

@Data
class Order implements Delayed {

  private String name;

  private long time;

  public Order(String name, long time, TimeUnit timeUnit) {
    this.name = name;
    this.time = System.currentTimeMillis() + (timeUnit != null ? timeUnit.toMillis(time) : 0);
  }

  @Override
  public long getDelay(TimeUnit unit) {
    return time - System.currentTimeMillis();
  }

  @Override
  public int compareTo(Delayed o) {
    Order order = (Order) o;
    long otherTime = order.getTime();
    if (time - otherTime <= 0) {
      return -1;
    } else {
      return 1;
    }
  }
}
