package com.architecture;

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

public interface LoginContactView extends IView {

    String getLoginName();

    String getLoginPassword();

    void check(int error);

    void loginSuccess();

    void loginFailure();
}
