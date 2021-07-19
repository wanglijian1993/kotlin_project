package com.android

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * 当前类的注释:application
 * 作者：WangLiJian on 2020/6/15.
 * 邮箱：wanglijian1214@gmail.com
 */


class MyApplication: Application() {
    companion object{
        var appContext:Context by Delegates.notNull()
    }
    override fun onCreate() {
        super.onCreate()
        appContext=this

    }
}