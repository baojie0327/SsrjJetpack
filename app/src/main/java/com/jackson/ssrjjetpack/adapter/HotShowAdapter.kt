package com.jackson.ssrjjetpack.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jackson.ssrjjetpack.BR
import com.jackson.ssrjjetpack.R
import com.jackson.ssrjjetpack.model.HotShowBean
import com.jackson.ssrjjetpack.utils.GlideUtils
import com.jackson.ssrjjetpack.viewmodel.HotShowItemViewModel
import java.text.DecimalFormat


/*
* HotShowAdapter  2019-08-19
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 19
*/
class HotShowAdapter(layoutResId: Int, data: MutableList<HotShowBean.SubjectsBean>) :
    BaseQuickAdapter<HotShowBean.SubjectsBean, HotShowAdapter.SubjectsViewHolder>(layoutResId, data) {


    override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
        val binding: ViewDataBinding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false)
        if (binding == null) {
            return super.getItemView(layoutResId, parent)
        }
        val view:View=binding.root
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding)
        return view

    }


    override fun convert(helper: SubjectsViewHolder, item: HotShowBean.SubjectsBean?) {
       val binging:ViewDataBinding=helper.getBinding()
        binging.setVariable(BR.hotShowItemViewModel,HotShowItemViewModel(item))
        binging.executePendingBindings()
    }


    /**  override fun convert(helper: BaseViewHolder, item: HotShowBean.SubjectsBean) {

    // 图片
    //  Glide.with(mContext).asBitmap().load(item.images?.medium).error(R.drawable.default_square_four).placeholder(R.drawable.default_square_four).into(helper.getView(R.id.img_movie))
    //        GlideUtils.loadUrlImage(mContext, item.images?.medium, helper.getView(R.id.img_movie))
    //        // 电影名
    //        helper.setText(R.id.tv_movie_name, item.title)
    //        // 评分
    //        helper.setRating(R.id.rating_movie, (item.rating?.average)?.div(2)!!.toFloat())
    //        // 导演
    //        helper.setText(R.id.tv_director, "导演：" + item.directors?.get(0)?.name)
    //        // 主演
    //        helper.setText(R.id.tv_leading_role, "主演：" + getActor(item.casts))
    //        // 看过
    //        helper.setText(R.id.tv_has_see, formatLargeNum(item.collect_count) + "人看过")

    }  **/

    class SubjectsViewHolder : BaseViewHolder {

        constructor(view: View) : super(view)

        fun getBinding(): ViewDataBinding {
            return itemView.getTag(R.id.BaseQuickAdapter_databinding_support) as ViewDataBinding
        }
    }

    /*
    获取主演
     */
    private fun getActor(acList: List<HotShowBean.SubjectsBean.Cast>?): String {
        if (acList != null && acList.isNotEmpty()) {
            val strBuilder = StringBuilder()
            acList.forEach {
                strBuilder.append(it.name + "/")
            }
            strBuilder.delete(strBuilder.length - 2, strBuilder.length)
            return strBuilder.toString()
        }
        return ""
    }

    /**
     * 格式化大数据
     */
    private fun formatLargeNum(number: Int): String {
        val ns: String = number.toString()
        if (ns.length < 5) {
            return ns
        }

        val a: Double = (number / 10000f).toDouble()
        val df = DecimalFormat(".0")
        return df.format(a) + "万"

    }

}