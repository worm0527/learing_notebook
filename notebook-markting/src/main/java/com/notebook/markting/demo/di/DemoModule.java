package com.notebook.markting.demo.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.notebook.markting.demo.aop.RefuseService;
import com.notebook.markting.demo.aop.RefuseServiceInterceptor;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author shuyuan.xu
 * @date 2021-01-12.
 */
public class DemoModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(Service.class).annotatedWith(Names.named("service1")).to(ServiceImpl.class).in(Scopes.SINGLETON);
    bind(Service.class).annotatedWith(Names.named("service2")).to(Service2Impl.class).in(Scopes.SINGLETON);
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(RefuseService.class), new RefuseServiceInterceptor());
  }

  @Provides
  @Singleton
  public Connection smsConnection() throws SQLException {
    String username = "root";
    String password = "1234567";
    String url = "jdbc:mysql://localhost:3306/marketing_sms";
    return DriverManager.getConnection(url, username, password);
  }

  @Provides
  @Singleton
  public DSLContext smsDSLContext(Connection connection) {
    Configuration configuration = new DefaultConfiguration()
        .set(connection)
        .set(SQLDialect.MYSQL);
    return DSL.using(configuration);
  }

}
