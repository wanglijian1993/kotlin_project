package com.android.frameworkkotlin.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.network.MyRetrofit
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        lifecycleScope.launch(Dispatchers.Main){
          val banner=MyRetrofit.api.requestBanner()
            tv_home.text=banner.data?.get(0)?.title
        }

    }

}