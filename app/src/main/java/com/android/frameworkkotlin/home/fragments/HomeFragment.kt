package com.android.frameworkkotlin.home.fragments

import android.view.View
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.databinding.FragmentHomeBinding

/**
 * 当前类的注释:首页Fragment
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
class HomeFragment : BaseFragment() {

    lateinit var mHomeView: FragmentHomeBinding


    companion object {
        var instance: HomeFragment = HomeFragment()
    }


    override fun bindView(): View = FragmentHomeBinding.inflate(layoutInflater).root


    override fun lazyLoad() {


    }


}