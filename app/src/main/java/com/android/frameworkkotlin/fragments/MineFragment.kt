package com.android.frameworkkotlin.fragments

import android.os.Bundle
import android.view.View
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.base.BaseViewModel
import com.android.frameworkkotlin.databinding.FragmentMineBinding

/**
 * 当前类的注释:我的主页
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
  class MineFragment :BaseFragment<BaseViewModel,FragmentMineBinding>(){
    lateinit var mMineFragment: FragmentMineBinding
   companion object{
       val instance = MineFragment()
   }

    override fun initVIew(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun lazyLoad() {
        TODO("Not yet implemented")
    }


}