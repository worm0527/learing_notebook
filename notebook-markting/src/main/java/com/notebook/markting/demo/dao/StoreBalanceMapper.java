package com.notebook.markting.demo.dao;

import static com.leyantech.jooq.marketing_sms.tables.StoreBalance.STORE_BALANCE;

import com.leyantech.jooq.marketing_sms.tables.daos.StoreBalanceDao;
import com.leyantech.jooq.marketing_sms.tables.pojos.StoreBalance;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.jooq.DSLContext;

import java.time.LocalDateTime;

/**
 * @author shuyuan.xu
 * @date 2021-01-12.
 */
@Singleton
public class StoreBalanceMapper {

  private DSLContext dslContext;

  private StoreBalanceDao storeBalanceDao;

  @Inject
  public StoreBalanceMapper(DSLContext dslContext) {
    this.dslContext = dslContext;
    storeBalanceDao = new StoreBalanceDao(dslContext.configuration());
  }

  public StoreBalance getStoreBalanceByCustomerId(String customerId) {
    return dslContext.select().from(STORE_BALANCE)
        .where(STORE_BALANCE.CUSTOMER_ID.eq(customerId))
        .fetchAny()
        .into(StoreBalance.class);
  }

  public StoreBalance initStoreBalance(String customerId) {
    StoreBalance storeBalance = new StoreBalance();
    storeBalance.setCustomerId(customerId);
    storeBalance.setBalanceCent(0L);
    storeBalance.setCreateTime(LocalDateTime.now());
    storeBalance.setUpdateTime(LocalDateTime.now());
    storeBalanceDao.insert(storeBalance);
    return storeBalance;
  }

  public int incrStoreBalance(String customerId, Long chargeAmount) {
    return dslContext.update(STORE_BALANCE)
        .set(STORE_BALANCE.BALANCE_CENT, STORE_BALANCE.BALANCE_CENT.plus(chargeAmount))
        .where(STORE_BALANCE.CUSTOMER_ID.eq(customerId))
        .execute();
  }

}
