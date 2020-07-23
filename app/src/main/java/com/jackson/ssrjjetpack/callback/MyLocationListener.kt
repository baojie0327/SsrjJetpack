package com.jackson.ssrjjetpack.callback

import android.content.Context
import android.location.Location


/*
* MyLocationListener  2019-11-12
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 11 12
*/
class MyLocationListener(private val context: Context, private val callback:(Location) -> Unit) {

    fun start(){
        // 连接接定位系统服务
    }

    fun stop(){
        // 断开与定位服务的连接
    }



}