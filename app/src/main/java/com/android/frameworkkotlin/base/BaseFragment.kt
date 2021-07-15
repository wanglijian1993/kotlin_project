package com.android.frameworkkotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.android.frameworkkotlin.ext.getVbClazz
import com.android.frameworkkotlin.ext.getVmClazz

/**
 * 当前类的注释:Fragment基类
 * 作者：WangLiJian on 2020/4/5.
 * 邮箱：wanglijian1214@gmail.com
 */
abstract class BaseFragment<VM:BaseViewModel,VB :ViewBinding>:Fragment(){



     lateinit var mViewModel: VM
     lateinit var mViewBinding: VB
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mType = getVbClazz<VB>(this,1)
        val mMethod = mType.getDeclaredMethod("inflate", LayoutInflater::class.java)
        mViewBinding= mMethod.invoke(null,layoutInflater) as VB
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVIew(savedInstanceState)
        mViewModel=createObserver()

    }
    override fun onResume() {
        super.onResume()
        lazyLoad()
    }

    /**
     * 初始化视图
     */
    abstract fun initVIew(savedInstanceState: Bundle?)

    /**
     *创建ViewModel生成订阅者
     */
    private fun createObserver():VM{
        return ViewModelProvider(this).get(getVmClazz(this,0))
    }

   /**
     * 懒加载 初始化数据
     */
    abstract fun lazyLoad()

}