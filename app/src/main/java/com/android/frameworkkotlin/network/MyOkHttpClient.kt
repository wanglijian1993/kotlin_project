package com.android.frameworkkotlin.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.time.Duration
import java.util.concurrent.TimeUnit

/**
 * 当前类的注释:okhttoClient端
 * 作者：WangLiJian on 2020/3/24.
 * 邮箱：wanglijian1214@gmail.com
 */

 lateinit var myOkHttpClient:OkHttpClient

 fun initOkHttpClient(){
     myOkHttpClient=OkHttpClient().newBuilder()
         .addInterceptor(LoggingInterceptor)
         .connectTimeout(10*1000,TimeUnit.MILLISECONDS)
         .readTimeout(10*1000,TimeUnit.MILLISECONDS)
         .callTimeout(10*1000,TimeUnit.MILLISECONDS)
         .build()
 }

 object LoggingInterceptor: Interceptor {
     override fun intercept(chain: Interceptor.Chain): Response {
         val request = chain.request()
         var t1=System.nanoTime()
         println("Sending request ${request.url} connection: ${chain.connection()} headers: ${request.headers}")
         val response:Response = chain.proceed(request)
         val t2 = System.nanoTime()
         println("Received Response ${response.request.url} time: ${(t2-t1)} headers: ${response.headers}")
        return response
     }

 }