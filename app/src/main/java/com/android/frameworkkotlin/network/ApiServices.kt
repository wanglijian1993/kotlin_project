package com.android.frameworkkotlin.network

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 当前类的注释:接口
 * 作者：WangLiJian on 2020/6/14.
 * 邮箱：wanglijian1214@gmail.com
 */
interface ApiServices {

    companion object {
        const val SERVER_URL = "https://wanandroid.com/"
    }

    /**
     * 请求banner
     */
    @GET("banner/json")
    suspend fun requestBanners()

    /**
     * 文章列表
     */
    @GET("article/list/{page}/json")
    suspend fun requestArticle(@Path("page") page: Int = 0)

}