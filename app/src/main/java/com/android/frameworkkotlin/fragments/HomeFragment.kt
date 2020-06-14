package com.android.frameworkkotlin.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.bean.BannerBean
import com.android.frameworkkotlin.network.MyRetrofit
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_page_content.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 当前类的注释:首页Fragment
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
   class HomeFragment:BaseFragment(){
    companion object {
     var instance :HomeFragment = HomeFragment()
    }


   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
       requestBanner()
      return inflater.inflate(R.layout.fragment_home,null)
   }

    fun requestBanner(){
        MyRetrofit.api.requestBanner().enqueue(object : Callback<BannerBean>{
            override fun onFailure(call: Call<BannerBean>, t: Throwable) {
            }

            override fun onResponse(call: Call<BannerBean>, response: Response<BannerBean>) {
                val result = response.body()
                tv_home.setText(result!!.data!!.get(0).title)
            }
        })
    }

}