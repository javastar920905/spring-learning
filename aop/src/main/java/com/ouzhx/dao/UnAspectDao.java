package com.ouzhx.dao;

import com.ouzhx.service.Member;

/**
 * Created by ouzhx on 2017/11/17. 没有进入切面的类
 */
public class UnAspectDao {
  public boolean add(Member member) {
    System.out.println("添加用户");
    return true;
  }

  public boolean del(long id) throws Exception {
    System.out.println("删除用户");
    throw new Exception("自定义异常");
  }
}
