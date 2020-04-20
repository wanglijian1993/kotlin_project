package com.android;

import android.app.Application;

import com.android.frameworkkotlin.network.MyOkHttpClientKt;

/**
 * 当前类的注释:
 * 作者：WangLiJian on 2020/3/23.
 * 邮箱：wanglijian1214@gmail.com
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MyOkHttpClientKt.initOkHttpClient();
    }
}
