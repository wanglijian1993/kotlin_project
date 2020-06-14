package com.android.frameworkkotlin.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 当前类的注释:封装Retrofit
 * 作者：WangLiJian on 2020/6/14.
 * 邮箱：wanglijian1214@gmail.com
 */

class MyRetrofit {

    companion object{
        //日志拦截器
        var httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        //Okhttp对象
        var okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder().baseUrl(baseurl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val api= retrofit.create(ApiServices::class.java)
    }
    

}