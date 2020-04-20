package com.android.frameworkkotlin.network

import com.android.frameworkkotlin.gson.toJson
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.IOException

/**
 * 当前类的注释:网络请求
 * 作者：WangLiJian on 2020/3/25.
 * 邮箱：wanglijian1214@gmail.com
 */

/**
 * get请求
 */
fun <T>OkHttp_GET(url:String,callback:ICallBack<Any>,t :Any){
    var request:Request=Request.Builder().url(url).build()
        myOkHttpClient.newCall(request).enqueue(object :Callback{
        override fun onFailure(call: Call, e: IOException) {
          callback.callbackFail(e.toString())

        }
        override fun onResponse(call: Call, response: Response) {
            val conten:String?=response.body!!.string()
                 val result:Any? =Gson().fromJson(
                     conten,
                     t::class.java
                 );
                callback.callbackSuccess(result)

        }
    })


    fun<T> OkHttp_POST(url:String,callback:ICallBack<Any>,t:Any){

        val requestBody:RequestBody= RequestBody.create("application/json; utf-8".toMediaTypeOrNull(), toJson(t))

        val request:Request=Request.Builder().url(url).post(requestBody).build()

         myOkHttpClient.newCall(request).enqueue(object :Callback{
             override fun onFailure(call: Call, e: IOException) {
                 callback.callbackFail(e.toString())

             }

             override fun onResponse(call: Call, response: Response) {
                 val conten:String?=response.body!!.string()
                 val result:Any? =Gson().fromJson(
                     conten,
                     t::class.java
                 );
                 callback.callbackSuccess(result)
             }
         })
    }

}


