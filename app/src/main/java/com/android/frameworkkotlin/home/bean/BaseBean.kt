package com.android.frameworkkotlin.home.bean

data class BaseBean<T>(
    val errorCode:Int,
    val errorMsg:String,
    val data:T
)