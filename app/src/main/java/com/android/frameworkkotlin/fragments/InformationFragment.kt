package com.android.frameworkkotlin.fragments

import android.view.View
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.databinding.FragmentInformationBinding

/**
 * 当前类的注释:资讯
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
 class InformationFragment : BaseFragment(){
    lateinit var mInformationView: FragmentInformationBinding
 companion object {
     var instance: InformationFragment = InformationFragment()
 }

    override fun bindView(): View = FragmentInformationBinding.inflate(layoutInflater).root


    override fun lazyLoad() {

    }


}