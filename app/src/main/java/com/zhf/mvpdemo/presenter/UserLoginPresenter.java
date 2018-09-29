package com.zhf.mvpdemo.presenter;

import android.os.Handler;

import com.zhf.mvpdemo.model.IUserBiz;
import com.zhf.mvpdemo.model.OnLoginListener;
import com.zhf.mvpdemo.model.User;
import com.zhf.mvpdemo.model.UserBiz;
import com.zhf.mvpdemo.view.IUserLoginView;

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login(String userName , String password) {
        userLoginView.showLoading();
        userBiz.login(userName, password, new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

}
