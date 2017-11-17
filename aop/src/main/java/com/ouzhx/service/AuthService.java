package com.ouzhx.service;

/**
 * Created by ouzhx on 2017/11/17.
 */
public class AuthService {
    public Member login(String loginName, String pwd) {
        System.out.println("执行了登录方法");
        return null;
    }

    public boolean logout(String loginName) {
        System.out.println("注销登录");
        return true;
    }
}
