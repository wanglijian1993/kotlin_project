package com.android.frameworkkotlin.fragments

import android.os.Bundle
import android.view.View
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.base.BaseViewModel
import com.android.frameworkkotlin.databinding.FragmentInformationBinding

/**
 * 当前类的注释:资讯
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
 class InformationFragment : BaseFragment<BaseViewModel,FragmentInformationBinding>(){
    lateinit var mInformationView: FragmentInformationBinding
 companion object {
     var instance: InformationFragment = InformationFragment()
 }

    override fun initVIew(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun lazyLoad() {
        TODO("Not yet implemented")
    }


}