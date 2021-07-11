package com.android.frameworkkotlin.base

/**
 * 当前类的注释:抽象响应体容器
 * 作者：WangLiJian on 2021/7/11.
 * 邮箱：wanglijian1214@gmail.com
 */
abstract class BaseResponse<T> {
    //抽象方法，用户的基类继承该类时，需要重写该方法
    abstract fun isSucces(): Boolean

    abstract fun responseData(): T

    abstract fun responseCode(): Int

    abstract fun responseMsg(): String
}