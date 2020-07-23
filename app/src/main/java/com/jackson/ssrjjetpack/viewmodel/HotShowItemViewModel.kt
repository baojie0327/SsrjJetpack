package com.jackson.ssrjjetpack.viewmodel

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.jackson.ssrjjetpack.model.HotShowBean
import java.text.DecimalFormat


/*
* HotShowItemViewModel  2019-08-21
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 21
*/
class HotShowItemViewModel(private var subjectsBean: HotShowBean.SubjectsBean?) : BaseObservable() {

    @get:Bindable
    var mSubjectsBean: HotShowBean.SubjectsBean? = null
        get() = subjectsBean
        set(value) {
            field = value
            notifyPropertyChanged(BR.mSubjectsBean)
        }


    @get:Bindable
    var rating: Float = 0.0f
        get() = mSubjectsBean?.rating?.average?.div(2)!!.toFloat()
        set(value) {
            field = value
            notifyPropertyChanged(BR.rating)
        }

    // 导演
    @get:Bindable
    var director = ""
        get() = "导演：" + mSubjectsBean?.directors?.get(0)?.name
        set(value) {
            field = value
            notifyPropertyChanged(BR.director)
        }

    // 主演
    @get:Bindable
    var actors: String = ""
        get() = "主演："+getActor(mSubjectsBean?.casts)
        set(value) {
            field = value
            notifyPropertyChanged(BR.actors)
        }

    // 看过
    @get:Bindable
    var hasSeen = ""
        get() = formatLargeNum(mSubjectsBean?.collect_count)+"人看过"
        set(value) {
            field = value
            notifyPropertyChanged(BR.hasSeen)
        }

    /*
    获取主演
     */
    private fun getActor(acList: List<HotShowBean.SubjectsBean.Cast>?): String {
        if (acList != null && acList.isNotEmpty()) {
            val strBuilder = StringBuilder()
            acList.forEach {
                strBuilder.append(it.name + " / ")
            }
            strBuilder.delete(strBuilder.length - 2, strBuilder.length)
            return strBuilder.toString()
        }
        return ""
    }

    /**
     * 格式化大数据
     */
    private fun formatLargeNum(number: Int?): String {
        val ns: String = number.toString()
        if (ns.length < 5) {
            return ns
        }

        val a: Double = (number?.div(10000f))!!.toDouble()
        val df = DecimalFormat(".0")
        return df.format(a) + "万"

    }


    fun viewOnClick(view: View) {

    }


}