package com.android.frameworkkotlin.home.adapter

import android.view.View
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseAdapter
import com.android.frameworkkotlin.databinding.LayoutArticleItemBinding
import com.android.frameworkkotlin.home.bean.Article
import kotlinx.android.synthetic.main.layout_article_item.view.*

class HomeArticleAdapter(val articleList: MutableList<Article>) :
    BaseAdapter<LayoutArticleItemBinding>() {
    override fun getItemCount(): Int = articleList.size
    override fun setItemVIewData(holder: BaseViewHolder, position: Int) {
        (holder.itemView as CardView).also {
            it.title.text = articleList[position].title
            it.time.text = articleList[position].niceShareDate
            it.tv_author.text = articleList[position].let {
                if (it.author != null) {
                    "作者:${it.author}"
                } else {
                    "分享人:${it.shareUser}"
                }
            }
            it.iv_favorites.let { iv ->
                if (articleList[position].collect) {
                    iv.setImageResource(R.mipmap.home_favorites_red)
                } else {
                    iv.setImageResource(R.mipmap.home_favorites_back)
                }
                iv.visibility = View.VISIBLE
            }

            it.chadptername.text = "${articleList[position].superChapterName}-${articleList[position].chapterName}"
            it.fl_favorites.setOnClickListener {
                print("点赞-----")
            }
        }
    }
}


