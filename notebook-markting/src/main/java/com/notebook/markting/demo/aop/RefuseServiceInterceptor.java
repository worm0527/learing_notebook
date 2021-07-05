package com.notebook.markting.demo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author shuyuan.xu
 * @date 2021-01-13.
 */
public class RefuseServiceInterceptor implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    throw new IllegalAccessException(invocation.getMethod().getName() + " refuse service!");
  }
}
