package com.mvplib.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

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

public abstract class MvpFragment<P extends BasePresenter> extends Fragment implements IView {

    public P mPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        mPresenter.attachView(getMvpView());
    }


    public abstract P createPresenter();

    @Override
    public IView getMvpView() {
        return this;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView(getRetainInstance());
    }
}
