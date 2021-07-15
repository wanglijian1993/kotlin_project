package com.android.frameworkkotlin.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.android.frameworkkotlin.ext.getVbClazz

abstract class  BaseAdapter<AVB : ViewBinding> : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val mVbClas= getVbClazz<AVB>(this,0)
        val mMethod = mVbClas.getDeclaredMethod("inflate", LayoutInflater::class.java,ViewGroup::class.java,Boolean::class.java)
        val layoutInflater = LayoutInflater.from(parent.context)
        val mViewBinding=mMethod.invoke(null,layoutInflater,parent,false) as AVB
        return BaseViewHolder(mViewBinding.root)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        setItemVIewData(holder, position)
    }

    class BaseViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    abstract fun setItemVIewData(holder: BaseViewHolder,position: Int)


}