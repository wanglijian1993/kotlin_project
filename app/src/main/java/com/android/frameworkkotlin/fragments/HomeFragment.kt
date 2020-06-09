package com.android.frameworkkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.bean.BannerBean
import com.android.frameworkkotlin.network.ICallBack

import com.android.frameworkkotlin.network.OkHttp_GET
import com.android.frameworkkotlin.network.banner_url

/**
 * 当前类的注释:首页Fragment
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
   class HomeFragment:BaseFragment(){
    companion object {
     var instance :HomeFragment = HomeFragment();
    }


   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
       requestNetwork()
      return inflater.inflate(R.layout.fragment_home,null)
   }
    fun requestNetwork(){
        OkHttp_GET(banner_url,callbackImp,BannerBean::class.java)
    }

    val callbackImp=object:ICallBack<BannerBean>{

        override fun callbackFail(msg: String) {
            println("error:"+msg)

        }

        override fun callbackSuccess(t: BannerBean) {
            println("success:"+t.toString())
        }

    }


}