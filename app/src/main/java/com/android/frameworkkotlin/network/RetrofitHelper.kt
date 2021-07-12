package com.android.frameworkkotlin.network

import com.android.MyApplication
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


//双重校验锁式-单例 封装NetApiService 方便直接快速调用简单的接口
val apiService: ApiServices by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    RetrofitHelper.INSTANCE.getApi(ApiServices::class.java, ApiServices.SERVER_URL)
}

/**
 * 当前类的注释: Retrofit网络封装
 * 作者：WangLiJian on 2021/7/11.
 * 邮箱：wanglijian1214@gmail.com
 */
class RetrofitHelper {

    companion object {
        val INSTANCE: RetrofitHelper by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitHelper()
        }
    }

    /**
     *获取retrofit的实例
     */
    private fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)  //自己配置
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> getApi(serviceClass: Class<T>, baseUrl: String): T {
        return getRetrofit(baseUrl).create(serviceClass)
    }

    private fun getOkHttpClient(): OkHttpClient {
        //添加一个log拦截器,打印所有的log
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        //可以设置请求过滤的水平,body,basic,headers
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //设置 请求的缓存的大小跟位置
        val cacheFile = File(MyApplication.appContext.cacheDir, "cache")
        val cache = Cache(cacheFile, 1024 * 1024 * 10) //50Mb 缓存的大小

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor) //日志,所有的请求响应度看到
            .cache(cache)  //添加缓存
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .build()
    }
}