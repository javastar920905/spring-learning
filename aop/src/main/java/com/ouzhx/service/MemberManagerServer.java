package com.ouzhx.service;

import org.springframework.stereotype.Service;

/**
 * Created by ouzhx on 2017/11/17.
 */
@Service
public class MemberManagerServer {
    public boolean add(Member member) {
        System.out.println("添加用户");
        return true;
    }

    public boolean del(long id) throws Exception {
        System.out.println("删除用户");
        throw new Exception("自定义异常");
    }

    public boolean modify(Member member) {
        System.out.println("修改用户");
        return true;
    }

    public Member query(String name) {
        System.out.println("查询用户");
        return new Member();
    }
}
