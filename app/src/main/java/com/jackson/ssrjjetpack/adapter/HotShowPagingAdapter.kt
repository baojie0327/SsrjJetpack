package com.jackson.ssrjjetpack.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseViewHolder
import com.jackson.ssrjjetpack.BR
import com.jackson.ssrjjetpack.R
import com.jackson.ssrjjetpack.databinding.ItemHotshowLayoutBinding
import com.jackson.ssrjjetpack.model.HotShowBean
import com.jackson.ssrjjetpack.viewmodel.HotShowItemViewModel


/*
* HotShowPagingAdapter  2019-08-26
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 26
*/
class HotShowPagingAdapter : PagedListAdapter<HotShowBean.SubjectsBean, HotShowPagingAdapter.SubjectsViewHolder>(mDiffCallback) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotShowPagingAdapter.SubjectsViewHolder {
        val binding: ItemHotshowLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_hotshow_layout, parent, false)
        val holder=SubjectsViewHolder(binding.root)
        holder.binding=binding
        return holder
    }

    override fun onBindViewHolder(holder: SubjectsViewHolder, position: Int) {
       val itemBean= getItem(position)

        holder.binding?.setVariable(BR.hotShowItemViewModel,HotShowItemViewModel(itemBean))
        holder.binding?.executePendingBindings()
//        if (holder.binding?.hotShowItemViewModel ==null){
//            holder.binding?.hotShowItemViewModel = HotShowItemViewModel(itemBean)
//        }else{
//            holder.binding?.hotShowItemViewModel!!.mSubjectsBean=itemBean
//        }
//        holder.binding?.executePendingBindings()
    }




    companion object {

        private val mDiffCallback: DiffUtil.ItemCallback<HotShowBean.SubjectsBean> =
            object : DiffUtil.ItemCallback<HotShowBean.SubjectsBean>() {

                override fun areItemsTheSame(
                    oldItem: HotShowBean.SubjectsBean,
                    newItem: HotShowBean.SubjectsBean
                ): Boolean = oldItem.id.equals(newItem.id)

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: HotShowBean.SubjectsBean,
                    newItem: HotShowBean.SubjectsBean
                ): Boolean {
                    return (oldItem==newItem)
                }

            }
    }

    class SubjectsViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        var binding:ItemHotshowLayoutBinding?=null


    }
}