package com.mvplib.presenter;

import com.mvplib.view.IView;

import java.lang.ref.WeakReference;

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

public class BasePresenter<V extends IView> {

    private WeakReference<V> mWeakR;

    public void attachView(IView view) {
        mWeakR = new WeakReference<V>((V) view);
    }

    public void detachView(boolean retainInstance) {
        if (mWeakR != null) {
            mWeakR.clear();
            mWeakR = null;
        }
    }

    /**
     * 获取presenter 对应的view
     *
     * @return若无对应实例返回null
     */
    public V getView() {
        return mWeakR == null ? null : mWeakR.get();
    }

    /**
     * 检查presenter 是否存在对应view
     *
     * @return 如果存在返回true, 否则返回false
     */
    public boolean isViewAttached() {
        return mWeakR != null && mWeakR.get() != null;
    }

}
