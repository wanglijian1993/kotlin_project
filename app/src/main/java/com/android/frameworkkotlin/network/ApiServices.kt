package com.android.frameworkkotlin.network

import com.android.frameworkkotlin.bean.BannerBean
import okhttp3.HttpUrl
import retrofit2.Call
import retrofit2.http.GET

/**
 * 当前类的注释:接口
 * 作者：WangLiJian on 2020/6/14.
 * 邮箱：wanglijian1214@gmail.com
 */
interface ApiServices {
     @GET(banner_url)
     fun requestBanner(): Call<BannerBean>;
}