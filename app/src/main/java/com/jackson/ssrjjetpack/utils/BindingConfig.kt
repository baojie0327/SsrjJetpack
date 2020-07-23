package com.jackson.ssrjjetpack.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter


/*
* BindingConfig  2019-08-12
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 12
*/
object BindingConfig {


    /**
     * 设置前置图片
     */
    @BindingAdapter("android:src")
    @JvmStatic
    fun setImageResource(view: ImageView, resId: Int) {
        view.setImageResource(resId)
    }

    /**
     * 设置背景图片
     */
    @BindingAdapter("android:background")
    @JvmStatic
    fun setBackground(view: ImageView, resId: Int) {
        view.setBackgroundResource(resId)
    }


}