package com.android.frameworkkotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 当前类的注释:封装Retrofit
 * 作者：WangLiJian on 2020/6/14.
 * 邮箱：wanglijian1214@gmail.com
 */

class MyRetrofit {

    companion object{
        val retrofit = Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val api= retrofit.create(ApiServices::class.java)
    }
    

}