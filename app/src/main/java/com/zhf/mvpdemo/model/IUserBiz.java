package com.zhf.mvpdemo.model;

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
