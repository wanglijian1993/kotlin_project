package com.android.frameworkkotlin.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.frameworkkotlin.home.bean.Data

/**
 * 当前类的注释:首页viewmodel
 * 作者：WangLiJian on 2021/7/11.
 * 邮箱：wanglijian1214@gmail.com
 */
class HomeModel : ViewModel() {


    var mArticle: MutableLiveData<Data> = MutableLiveData()


}