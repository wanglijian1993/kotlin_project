package com.android.frameworkkotlin.network

/**
 * 当前类的注释: 网络请求接口返回
 * 作者：WangLiJian on 2020/3/29.
 * 邮箱：wanglijian1214@gmail.com
 */
 interface ICallBack<T> {

    fun callbackSuccess(t : T)

    fun callbackFail(msg : String)

}

