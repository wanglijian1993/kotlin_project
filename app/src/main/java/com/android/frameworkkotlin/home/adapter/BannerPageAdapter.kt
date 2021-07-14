package com.android.frameworkkotlin.home.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.android.frameworkkotlin.home.bean.Banner
import com.bumptech.glide.Glide

class BannerPageAdapter (val banners:MutableList<Banner>): PagerAdapter() {



    override fun getCount(): Int = banners.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = ImageView(container.context)
        view.scaleType = ImageView.ScaleType.FIT_XY
        Glide.with(container.context).load(banners[position].imagePath).into(view)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any)= container.removeView(`object` as View)

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view==`object`
}