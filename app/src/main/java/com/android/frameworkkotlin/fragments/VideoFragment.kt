package com.android.frameworkkotlin.fragments

import android.view.View
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.databinding.FragmentVideoBinding

/**
 * 当前类的注释:视频
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
   class VideoFragment: BaseFragment() {

   lateinit var mViewFragment: FragmentVideoBinding

   companion object {
      val instance = VideoFragment()
   }

   override fun bindView(): View = FragmentVideoBinding.inflate(layoutInflater).root
   override fun lazyLoad() {

   }



}