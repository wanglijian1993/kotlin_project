package com.android.frameworkkotlin.adapter

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * 当前类的注释:首页ViewPager
 * 作者：WangLiJian on 2020/4/2.
 * 邮箱：wanglijian1214@gmail.com
 */
class ContentAdapter(@NonNull fragmentManager:FragmentActivity,fragments:List<Fragment>):
    FragmentStateAdapter(fragmentManager) {
    val mFragments=fragments
    override fun getItemCount(): Int=mFragments.size
    override fun createFragment(position: Int): Fragment=mFragments.get(position)

}

