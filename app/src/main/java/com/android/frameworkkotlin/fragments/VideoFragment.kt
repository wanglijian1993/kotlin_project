package com.android.frameworkkotlin.fragments

import android.os.Bundle
import android.view.View
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.base.BaseViewModel
import com.android.frameworkkotlin.databinding.FragmentVideoBinding

/**
 * 当前类的注释:视频
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
   class VideoFragment: BaseFragment<BaseViewModel,FragmentVideoBinding>() {

   lateinit var mViewFragment: FragmentVideoBinding

   companion object {
      val instance = VideoFragment()
   }

   override fun initVIew(savedInstanceState: Bundle?) {
   }

   override fun lazyLoad() {
   }


}