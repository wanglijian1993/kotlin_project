package com.android.frameworkkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseFragment

/**
 * 当前类的注释:视频
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
   class VideoFragment: BaseFragment(){

   companion object{
      val instance =VideoFragment()
   }

   override fun initLayout(): Int=R.layout.fragment_video

   override fun initView() {

   }

   override fun lazyLoad() {

   }

   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {

      return super.onCreateView(inflater, container, savedInstanceState)
   }


}