package com.android.frameworkkotlin.adapter

import android.content.Context
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * 当前类的注释:首页ViewPager
 * 作者：WangLiJian on 2020/4/2.
 * 邮箱：wanglijian1214@gmail.com
 */
class ContentAdapter(@NonNull fragmentManager:FragmentManager,fragments:List<Fragment>):
    FragmentStateAdapter(fragmentManager) {
    val mFragments=fragments

    override fun getItem(position: Int): Fragment=mFragments.get(position)


    override fun getItemCount(): Int=mFragments.size
}

