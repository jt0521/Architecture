package com.architecture.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.architecture.login.UserInfo;

/**
 * Copyright (C) 2018 重庆呼我出行网络科技有限公司
 * <p>
 * 版权所有
 * <p>
 * 功能描述：取、存数据等操作。目的为：简化presenter
 * <p>
 * <p>
 * 作者：Created by tgl on 2019/1/24.
 * <p>
 * 修改人：
 * 修改描述：
 * 修改日期
 */

public class LoginData {
    public static final String file_name = "login";
    private static final String key_name = "name";
    private static final String key_password = "password";

    /**
     * 读取数据
     *
     * @param context
     * @return
     */
    public static UserInfo getUserData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(key_name, null);
        String password = sharedPreferences.getString(key_password, null);
        if (name == null && password == null) {
            return null;
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.name = name;
            userInfo.password = password;
            return userInfo;
        }
    }

    /**
     * 写入数据
     *
     * @param context
     * @param userInfo
     */
    public static void saveUserData(Context context, UserInfo userInfo) {
        SharedPreferences sp = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        if (userInfo == null) {
            sp.edit().clear().commit();
        } else {
            sp.edit()
                    .putString(key_name, userInfo.name)
                    .putString(key_password, userInfo.password)
                    .commit();
        }
    }
}
