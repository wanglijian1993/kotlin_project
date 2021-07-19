package com.android.frameworkkotlin.home.fragments

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.databinding.FragmentHomeBinding
import com.android.frameworkkotlin.decorate.SpaceItemDecoration
import com.android.frameworkkotlin.ext.init
import com.android.frameworkkotlin.home.adapter.BannerPageAdapter
import com.android.frameworkkotlin.home.adapter.HomeArticleAdapter
import com.android.frameworkkotlin.home.viewmodel.HomeViewModel
import com.android.frameworkkotlin.recyclerext.DefineLoadMoreView
import com.android.frameworkkotlin.utils.dp2px
import com.android.frameworkkotlin.utils.initFooter
import com.android.frameworkkotlin.utils.obtainViewModel
import com.yanzhenjie.recyclerview.SwipeRecyclerView

/**
 * 当前类的注释:首页Fragment
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>() {

   private  lateinit var mHomeViewModel:HomeViewModel
   private val mArticleAdapter:HomeArticleAdapter by lazy { HomeArticleAdapter(arrayListOf()) }
    //recyclerview的底部加载view 因为在首页要动态改变他的颜色，所以加了他这个字段
    private lateinit var footView: DefineLoadMoreView
    companion object {
        var instance: HomeFragment = HomeFragment()
    }




    override fun lazyLoad() {
        mHomeViewModel= obtainViewModel(this,HomeViewModel::class.java)
        mHomeViewModel.requestArticleList()
        mHomeViewModel.requestBanner()
        mHomeViewModel.mArticle.observe(this,
            Observer{ articles ->

            })
        mHomeViewModel.mBanner.observe(this, Observer {
            mViewBinding.vpBanner.adapter=BannerPageAdapter(it).apply {

            }
        })
    }

    override fun initVIew(savedInstanceState: Bundle?) {
        mViewBinding.rvArticle.let {
            it.layoutManager=LinearLayoutManager(context)
            it.adapter=mArticleAdapter
            it.addItemDecoration(SpaceItemDecoration(0, dp2px(8f), false))

            it.isNestedScrollingEnabled=true
            footView = it.initFooter(SwipeRecyclerView.LoadMoreListener {
                mHomeViewModel.mArticle.observe(this,
                    Observer{ articles ->

                    })
            })
        }


    }


}