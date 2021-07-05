package com.notebook.markting.demo.service;

import com.leyantech.jooq.marketing_sms.tables.pojos.RechargeRecord;
import com.leyantech.jooq.marketing_sms.tables.pojos.StoreBalance;

import com.google.inject.Inject;
import com.notebook.markting.demo.aop.RefuseService;
import com.notebook.markting.demo.dao.RechargeRecordMapper;
import com.notebook.markting.demo.dao.StoreBalanceMapper;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author shuyuan.xu
 * @date 2021-01-13.
 */
public class DemoService {

  @Inject
  private RechargeRecordMapper rechargeRecordMapper;

  @Inject
  private StoreBalanceMapper storeBalanceMapper;

  public Long chargeStoreBalance(String customerId, Long chargeAmount) {
    rechargeRecordMapper.saveRechargeRecord(customerId, customerId,
        UUID.randomUUID().toString(), UUID.randomUUID().toString(), chargeAmount);
    StoreBalance storeBalance = storeBalanceMapper.getStoreBalanceByCustomerId(customerId);
    if (Objects.isNull(storeBalance)) {
      storeBalance = storeBalanceMapper.initStoreBalance(customerId);
    }
    int updateRows = storeBalanceMapper.incrStoreBalance(customerId, chargeAmount);
    if (updateRows > 0) {
      return storeBalance.getBalanceCent() + chargeAmount;
    } else {
      return storeBalance.getBalanceCent();
    }
  }

  @RefuseService
  public List<RechargeRecord> listRechargeRecord(
      String customerId, Integer currentPage, Integer pageSize) {
    Integer start = (currentPage - 1) * pageSize;
    return rechargeRecordMapper.listRechargeRecord(customerId, start, pageSize);
  }

}
