package com.jackson.ssrjjetpack.view.fragment

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import com.jackson.ssrjjetpack.R


/*
* StatusBarHeightView  2019-07-23
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 07 23
*/
class StatusBarHeightView :LinearLayout{

    private  var statusBarHeight: Int=0
    private  var type: Int=0

    constructor(context: Context,attrs: AttributeSet):super(context,attrs){
        init(attrs)
    }
    constructor(context: Context,attrs: AttributeSet,defStyleAttr:Int):super(context,attrs,defStyleAttr){
        init(attrs)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr:Int, defStyleRes:Int):super(context,attrs,defStyleAttr,defStyleRes){
        init(attrs)
    }


    private fun init(attrs: AttributeSet?) {
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (resourceId > 0) {
                statusBarHeight = resources.getDimensionPixelSize(resourceId)
            }
        } else {
            //低版本 直接设置0
            statusBarHeight = 0
        }
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.StatusBarHeightView
            )
            type = typedArray.getInt(R.styleable.StatusBarHeightView_use_type, 0)
            typedArray.recycle()
        }
        if (type == 1) {
            setPadding(paddingLeft, statusBarHeight, paddingRight, paddingBottom)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (type == 0) {
            setMeasuredDimension(
                View.getDefaultSize(suggestedMinimumWidth, widthMeasureSpec),
                statusBarHeight
            )
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }


}