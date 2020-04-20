package com.android.frameworkkotlin.gson

import com.google.gson.Gson

/**
 * 当前类的注释:gson工具类
 * 作者：WangLiJian on 2020/3/31.
 * 邮箱：wanglijian1214@gmail.com
 */
/**
 * 为什么这么设计如果json版本升级方便替换方法
 */
fun toJson(any : Any)=Gson().toJson(any)