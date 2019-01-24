package com.architecture;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvplib.view.activity.MvpActivity;

public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginContactView, View.OnClickListener {

    EditText mNameEt;
    EditText mPasswordEt;
    Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt = findViewById(R.id.name_et);
        mPasswordEt = findViewById(R.id.password_et);
        mLoginBtn = findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                mPresenter.login();
                break;
        }
    }

    @Override
    public String getLoginName() {
        return mNameEt.getText().toString();
    }

    @Override
    public String getLoginPassword() {
        return mPasswordEt.getText().toString();
    }

    @Override
    public void check(int error) {
        switch (error) {
            case LoginPresenter.ERROR_NAME:
                Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
                break;
            case LoginPresenter.ERROR_PASS:
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

}
