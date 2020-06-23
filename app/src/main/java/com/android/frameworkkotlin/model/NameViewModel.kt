package com.android.frameworkkotlin.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 当前类的注释:
 * 作者：WangLiJian on 2020/6/17.
 * 邮箱：wanglijian1214@gmail.com
 */
class NameViewModel: ViewModel() {

    // Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    // Rest of the ViewModel...
}