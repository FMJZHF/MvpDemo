package com.zhf.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zhf.mvpdemo.R;
import com.zhf.mvpdemo.model.User;
import com.zhf.mvpdemo.presenter.UserLoginPresenter;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnRegister;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mEtUsername = findViewById(R.id.id_et_username);
        mEtPassword = findViewById(R.id.id_et_password);

        mBtnRegister = findViewById(R.id.id_btn_register);
        mBtnLogin = findViewById(R.id.id_btn_login);

        mPbLoading = findViewById(R.id.id_pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login(mEtUsername.getText().toString() ,  mEtPassword.getText().toString());
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserLoginActivity.this, "跳转到注册页面", Toast.LENGTH_SHORT).show();
            }
        });
    }
     @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " 登录成功 , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

}
