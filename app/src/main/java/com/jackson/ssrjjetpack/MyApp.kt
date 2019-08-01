package com.jackson.ssrjjetpack

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex


/*
* MyApp  2019-07-22
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 07 22
*/
class MyApp: Application() {



    override fun onCreate() {
        super.onCreate()
        instance=this
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

   companion object{
       lateinit var instance:MyApp
   }
}