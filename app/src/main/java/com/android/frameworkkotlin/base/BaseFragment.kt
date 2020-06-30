package com.android.frameworkkotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * 当前类的注释:Fragment基类
 * 作者：WangLiJian on 2020/4/5.
 * 邮箱：wanglijian1214@gmail.com
 */
abstract class BaseFragment:Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(initLayout(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
        lazyLoad()
    }

    /**
     * 初始化视图
     */
    abstract fun initLayout():Int

    /**
     * 初始化 ViewI
     */
    abstract fun initView()

    /**
     * 懒加载 初始化数据
     */
    abstract fun lazyLoad()

}