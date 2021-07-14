package com.android.frameworkkotlin.home.fragments

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.databinding.FragmentHomeBinding
import com.android.frameworkkotlin.home.adapter.BannerPageAdapter
import com.android.frameworkkotlin.home.adapter.HomeArticleAdapter
import com.android.frameworkkotlin.home.viewmodel.HomeViewModel
import com.android.frameworkkotlin.utils.obtainViewModel

/**
 * 当前类的注释:首页Fragment
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>() {

   private  lateinit var mHomeViewModel:HomeViewModel

    companion object {
        var instance: HomeFragment = HomeFragment()
    }




    override fun lazyLoad() {
        mHomeViewModel= obtainViewModel(this,HomeViewModel::class.java)
        mHomeViewModel.requestArticleList()
        mHomeViewModel.requestBanner()
        mHomeViewModel.mArticle.observe(this,
            Observer{ articles ->
                mViewBinding.rvArticle.let {
                    it.layoutManager=LinearLayoutManager(context)
                    it.adapter=HomeArticleAdapter(articles)
                }
            })
        mHomeViewModel.mBanner.observe(this, Observer {
            mViewBinding.vpBanner.adapter=BannerPageAdapter(it).apply {

            }
        })
    }

    override fun initVIew(savedInstanceState: Bundle?) {
    }


}