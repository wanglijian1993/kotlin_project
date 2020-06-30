package com.android.frameworkkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_information.*
import kotlinx.android.synthetic.main.fragment_information.view.*
import kotlinx.android.synthetic.main.item_adapter_text.view.*

/**
 * 当前类的注释:资讯
 * 作者：WangLiJian on 2020/4/4.
 * 邮箱：wanglijian1214@gmail.com
 */
 class InformationFragment : BaseFragment(){
 companion object {
  var instance :InformationFragment = InformationFragment();
 }


 override fun initLayout(): Int=R.layout.fragment_information

 override fun initView() {
  val arrayOf = arrayListOf("第一行", "第二行", "第三行", "第四行")
    this.rv.layoutManager=LinearLayoutManager(context)
     this.rv.adapter=MyAdapter(arrayOf)
 }

 override fun lazyLoad() {

 }


 class MyAdapter(val datas:ArrayList<String>) : RecyclerView.Adapter<MyAdapter.PartViewHolder>() {


  class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
   fun bind(string: String) {
    itemView.tv_item.text=string

   }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartViewHolder {
    val view:View=LayoutInflater.from(parent.context).inflate(R.layout.item_adapter_text,parent,false)
    return PartViewHolder(view)
  }

  override fun getItemCount(): Int =datas.size

  override fun onBindViewHolder(holder: PartViewHolder, position: Int) {
     holder.bind(datas.get(position))
     holder.itemView.setOnClickListener(View.OnClickListener {
      notifyItemRangeChanged(position,itemCount)
     })
  }
 }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


}