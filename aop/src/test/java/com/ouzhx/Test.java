package com.ouzhx;

import com.ouzhx.service.MemberManagerServer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ouzhx on 2017/11/17.
 */
@ContextConfiguration()
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {
  @Autowired
  private MemberManagerServer server;

  @org.junit.Test
  public void test() {
    server.add(null);
  }
}
