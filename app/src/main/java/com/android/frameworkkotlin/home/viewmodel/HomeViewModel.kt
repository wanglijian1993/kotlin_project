package com.android.frameworkkotlin.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.frameworkkotlin.base.BaseViewModel
import com.android.frameworkkotlin.home.bean.ArticleList
import com.android.frameworkkotlin.network.ApiServices
import com.android.frameworkkotlin.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 当前类的注释:首页viewmodel
 * 作者：WangLiJian on 2021/7/11.
 * 邮箱：wanglijian1214@gmail.com
 */
class HomeViewModel : BaseViewModel() {


    var mArticle: MutableLiveData<List<ArticleList>> = MutableLiveData()
    /**
     * 请求文章列表
     */
    fun requestArticleList(page:Int=0) {
        CoroutineScope(Dispatchers.Main).launch {
            val requestArticle =
                RetrofitHelper.INSTANCE.getApi(ApiServices::class.java, ApiServices.SERVER_URL)
                    .requestArticle(page)

              if(requestArticle.errorCode ==0&& requestArticle.data!=null){
                  mArticle.postValue(requestArticle.data.datas)
              }

        }

    }


    fun requestBanner(){
        val launch = CoroutineScope(Dispatchers.Main).launch {
            RetrofitHelper.INSTANCE.getApi(ApiServices::class.java, ApiServices.SERVER_URL)
                .requestBanners()


        }
    }

}


