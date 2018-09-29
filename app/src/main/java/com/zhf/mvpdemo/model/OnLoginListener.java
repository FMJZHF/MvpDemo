package com.zhf.mvpdemo.model;

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
