package com.jackson.ssrjjetpack.callback

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.jackson.ssrjjetpack.utils.MessageEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import timber.log.Timber


/*
* EventBusObserver  2019-11-18
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* EventBus 根据生命周期的监听器
* @author Jackson
* @version 1.0.0
* since 2019 11 18
*/
class EventBusObserver(var lifecycleCallback: LifecycleCallback):LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun registerEventBus(){
        EventBus.getDefault().register(this)
}

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unregisterEventBus(){
        EventBus.getDefault().unregister(this)
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEvent: MessageEvent){
        if (messageEvent.message.isNotEmpty()){
            lifecycleCallback.update(messageEvent.message)
        }
    }

}