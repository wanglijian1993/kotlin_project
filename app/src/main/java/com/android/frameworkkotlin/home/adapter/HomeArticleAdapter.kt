package com.android.frameworkkotlin.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.databinding.LayoutArticleItemBinding
import com.android.frameworkkotlin.home.bean.Article

class HomeArticleAdapter(val articleList:MutableList<Article>) :  RecyclerView.Adapter<HomeArticleAdapter.ViewHolder>(){






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder=
        ViewHolder(LayoutArticleItemBinding.inflate(LayoutInflater.from(parent.context)).root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder.itemView as LayoutArticleItemBinding).also {
            it.title.text=articleList[position].title
            it.time.text=articleList[position].niceShareDate
            it.tvAuthor.text=articleList[position].let {
                if(it.author!=null){
                     "作者:${it.author}"
                }else{
                     "分享人:${it.shareUser}"
                }
            }
            it.chadptername.text="分类:${articleList[position].superChapterName}"
        }



     }

    override fun getItemCount(): Int =articleList.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}