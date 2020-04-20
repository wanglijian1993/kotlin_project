package com.android.frameworkkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseFragment

/**
 * 当前类的注释:资讯
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
 class InformationFragment : BaseFragment(){
 companion object {
  var instance :InformationFragment = InformationFragment();
 }
 override fun onCreateView(
  inflater: LayoutInflater,
  container: ViewGroup?,
  savedInstanceState: Bundle?
 ): View? {
  return inflater.inflate(R.layout.fragment_information,null)
 }
}