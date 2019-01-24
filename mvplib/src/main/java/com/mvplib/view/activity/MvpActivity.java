package com.mvplib.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.mvplib.presenter.BasePresenter;
import com.mvplib.view.IView;

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

public abstract class MvpActivity<P extends BasePresenter> extends FragmentActivity implements IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(getMvpView());
    }

    public abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView(false);
    }

    @Override
    public IView getMvpView() {
        return this;
    }
}
