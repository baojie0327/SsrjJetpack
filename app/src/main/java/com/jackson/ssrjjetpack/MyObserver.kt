package com.jackson.ssrjjetpack

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


/*
* MyObserver  2019-07-31
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 07 31
*/
class MyObserver(var lifecycle:Lifecycle,var lifecycleCallback:LifecycleCallback) :LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun connectOnCreate(){
        print("OnCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun connectOnStart() {
        print("OnStart")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectOnResume(){
        print("OnResume")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun disconnectOnDestroye() {

        print("OnDestroy")
    }

    private fun print(string:String){
        lifecycleCallback.update(string)
    }

}