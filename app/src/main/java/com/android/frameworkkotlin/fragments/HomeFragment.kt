package com.android.frameworkkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseFragment
import kotlin.properties.Delegates

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

      return inflater.inflate(R.layout.fragment_home,null)
   }
}