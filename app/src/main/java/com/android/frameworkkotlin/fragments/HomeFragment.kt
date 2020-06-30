package com.android.frameworkkotlin.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseFragment
import com.android.frameworkkotlin.network.MyRetrofit
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_adapter_text.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 当前类的注释:首页Fragment
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
class HomeFragment : BaseFragment() {

    companion object {
        var instance: HomeFragment = HomeFragment()
    }

    lateinit var datas: MutableList<String>

    override fun initLayout(): Int = R.layout.fragment_home


    override fun initView() {
        datas = mutableListOf()
        for (i in 0..20) {
            datas.add(i,"data:" + i)
        }
        rvContent.layoutManager = LinearLayoutManager(context)
        rvContent.adapter = HomeAdapter(datas)
    }

    override fun lazyLoad() {

    }


    class HomeAdapter(val datas: List<String>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_adapter_text, parent, false);
            return ViewHolder(view)
        }

        override fun getItemCount(): Int = datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(value: String) {
                itemView.tv_item.text = value
            }
        }
    }

}