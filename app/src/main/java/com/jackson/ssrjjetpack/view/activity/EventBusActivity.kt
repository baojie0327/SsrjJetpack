package com.jackson.ssrjjetpack.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jackson.ssrjjetpack.BaseActivity
import com.jackson.ssrjjetpack.R
import com.jackson.ssrjjetpack.callback.EventBusObserver
import com.jackson.ssrjjetpack.callback.LifecycleCallback
import com.jackson.ssrjjetpack.utils.MessageEvent
import kotlinx.android.synthetic.main.activity_event_bus.*
import org.greenrobot.eventbus.EventBus

class EventBusActivity : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus)

        btn_send.setOnClickListener(this)

        lifecycle.addObserver(EventBusObserver(object :LifecycleCallback{
            override fun update(message: String) {
                tv_show.text=message
            }

        }))

    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_send -> {
                val messageEvent= MessageEvent()
                messageEvent.message=et_input.text.toString()
                EventBus.getDefault().post(messageEvent)

            }
        }
    }
}
