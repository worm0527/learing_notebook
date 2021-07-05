package com.notebook.markting.demo.dao;

import static com.leyantech.jooq.marketing_sms.tables.RechargeRecord.RECHARGE_RECORD;

import com.leyantech.jooq.marketing_sms.tables.daos.RechargeRecordDao;
import com.leyantech.jooq.marketing_sms.tables.pojos.RechargeRecord;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.jooq.DSLContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shuyuan.xu
 * @date 2021-01-12.
 */
@Singleton
public class RechargeRecordMapper {

  private DSLContext dslContext;

  private RechargeRecordDao rechargeRecordDao;

  @Inject
  public RechargeRecordMapper(DSLContext dslContext) {
    this.dslContext = dslContext;
    this.rechargeRecordDao = new RechargeRecordDao(dslContext.configuration());
  }

  /**
   * 分页查询充值记录
   *
   * @param customerId
   * @param start
   * @param pageSize
   * @return
   */
  public List<RechargeRecord> listRechargeRecord(
      String customerId, Integer start, Integer pageSize) {
    return dslContext.selectFrom(RECHARGE_RECORD)
        .where(RECHARGE_RECORD.CUSTOMER_ID.eq(customerId))
        .orderBy(RECHARGE_RECORD.ID.desc())
        .limit(start, pageSize)
        .fetchInto(RechargeRecord.class);
  }

  /**
   * 保存充值记录
   *
   * @param customerId
   * @param storeId
   * @param tradeNo
   * @param orderNo
   * @param amountCent
   */
  public void saveRechargeRecord(String customerId, String storeId,
      String tradeNo, String orderNo, Long amountCent) {
    RechargeRecord rechargeRecord = new RechargeRecord();
    rechargeRecord.setCustomerId(customerId);
    rechargeRecord.setStoreId(storeId);
    rechargeRecord.setTradeNo(tradeNo);
    rechargeRecord.setOrderNo(orderNo);
    rechargeRecord.setAmountCent(amountCent); // 充值金额
    rechargeRecord.setCreateTime(LocalDateTime.now());
    rechargeRecord.setUpdateTime(LocalDateTime.now());
    rechargeRecordDao.insert(rechargeRecord);
  }

  /**
   * 充值记录数
   *
   * @param customerId
   * @return
   */
  public Integer getCountByCustomerId(String customerId) {
    return dslContext.selectCount().from(RECHARGE_RECORD)
        .where(RECHARGE_RECORD.CUSTOMER_ID.eq(customerId))
        .fetchAny()
        .value1();
  }

}
