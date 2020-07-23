package com.jackson.ssrjjetpack.viewmodel

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.jackson.ssrjjetpack.R


/*
* TitleViewModel  2019-08-07
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 07
*/
class TitleViewModel : BaseObservable() {


    // 左侧文字
    @get:Bindable
    var leftText: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.leftText)
        }




   //  左侧的图片
    @get:Bindable
    var leftIconResId: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.leftIconResId)
        }

    // 左侧按键点击事件
    @get:Bindable
    var leftClickListener: View.OnClickListener? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.leftClickListener)
        }

    // 中间的文字
    @get:Bindable
    var title: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    // 右侧的文字
    @get:Bindable
    var rightTitle: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.rightTitle)
        }

    // 右侧的图片
    @get:Bindable
    var rightIconResId: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.rightIconResId)
        }


    // 右侧按键点击事件
    @get:Bindable
    var rightClickListener: View.OnClickListener? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.rightClickListener)
        }


    fun onClickView(view: View) {
        when (view.id) {
            R.id.ll_left -> leftClickListener?.onClick(view)
            R.id.ll_right,R.id.tv_right_title-> rightClickListener?.onClick(view)
        }

    }


}