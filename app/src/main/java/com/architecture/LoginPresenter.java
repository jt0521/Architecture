package com.architecture;

import android.text.TextUtils;

import com.mvplib.presenter.BasePresenter;

/**
 * Copyright (C) 2018 重庆呼我出行网络科技有限公司
 * <p>
 * 版权所有
 * <p>
 * 功能描述：
 * <p>
 * <p>
 * 作者：Created by tgl on 2019/1/23.
 * <p>
 * 修改人：
 * 修改描述：
 * 修改日期
 */

public class LoginPresenter extends BasePresenter<LoginActivity> {

    public static final int ERROR_NAME = 1;
    public static final int ERROR_PASS = 2;

    public void login() {
        String loginName = getView().getLoginName();
        String loginPassword = getView().getLoginPassword();
        if (TextUtils.isEmpty(loginName)) {
            getView().check(ERROR_NAME);
            return;
        }
        if (TextUtils.isEmpty(loginPassword)) {
            getView().check(ERROR_PASS);
            return;
        }
        if (getView() != null) {
            if (TextUtils.equals(loginName, loginPassword)) {
                getView().loginSuccess();
            } else {
                getView().loginFailure();
            }
        }
    }

}
