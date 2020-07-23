package com.jackson.ssrjjetpack.utils

import android.content.Context
import android.media.Image
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.jackson.ssrjjetpack.R
import kotlinx.android.synthetic.main.fragment_hot_show.view.*


/*
* GlideUtils  2019-08-20
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 20
*/
object GlideUtils {

    fun loadUrlImage(context:Context,url:String?,imageView:ImageView){
        Glide.with(context)
            .asBitmap()
            .load(url)
            .error(R.drawable.default_square_four)
            .placeholder(R.drawable.default_square_four)
            .into(imageView)
    }

    /**
     * 加载本地图片
     */
    @BindingAdapter("image")
    @JvmStatic
    fun getLocalImage(imageView:ImageView,path:Int){
        Glide.with(imageView.context)
            .load(path)
            .error(R.drawable.default_square_four)
            .placeholder(R.drawable.default_square_four)
            .into(imageView)
    }

    @BindingAdapter("image_url")
    @JvmStatic
    fun getInternetImage(imageView:ImageView,picUrl:String){
        Glide.with(imageView.context).
            load(picUrl).error(R.drawable
            .default_square_four)
            .placeholder(R.drawable.default_square_four)
            .into(imageView)
    }


}