package com.notebook.markting.demo.dao;

import com.leyantech.jooq.marketing_sms.tables.pojos.RechargeRecord;

import com.google.common.base.Stopwatch;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.notebook.markting.demo.di.DemoModule;
import com.notebook.markting.demo.service.DemoService;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shuyuan.xu
 * @date 2021-01-12.
 */
public class Test {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Injector injector = Guice.createInjector(new DemoModule());

    String customerId = "bb4d8797-bb4a-41f9-bb84-eae560a00419";
    DemoService demoService = injector.getInstance(DemoService.class);
    Stopwatch sw = Stopwatch.createStarted();
//    for (int i = 0; i < 10; i++) {
//      Long balance = demoService.chargeStoreBalance(customerId, (long) (Math.random() * 100000L));
//      System.out.println(balance);
//    }

    List<RechargeRecord> rechargeRecords = demoService.listRechargeRecord(customerId, 1, 5);
    rechargeRecords.stream().forEach(System.out::println);

    long consuming = sw.elapsed(TimeUnit.MILLISECONDS);
    System.out.println("consumint time:" + consuming);
  }

}
