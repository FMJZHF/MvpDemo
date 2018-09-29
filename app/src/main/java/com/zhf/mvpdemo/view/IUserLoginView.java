package com.zhf.mvpdemo.view;

import com.zhf.mvpdemo.model.User;

public interface IUserLoginView {
    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
