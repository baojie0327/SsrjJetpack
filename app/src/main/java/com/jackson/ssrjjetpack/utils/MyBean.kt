package com.jackson.ssrjjetpack.utils


/*
* MyBean  2019-11-12
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 11 12
*/
class MyBean {

    fun testCall(callback:(String)->Unit){
        callback("回调")
    }
}