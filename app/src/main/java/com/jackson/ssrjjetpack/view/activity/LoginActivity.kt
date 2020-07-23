package com.jackson.ssrjjetpack.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.jackson.ssrjjetpack.BaseActivity
import com.jackson.ssrjjetpack.R

class LoginActivity : BaseActivity() {


    var handler:Handler= @SuppressLint("HandlerLeak")
    object:Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       initAppBar(1)

        val msg:Message= Message.obtain()
        msg.what=1
        msg.obj="AA"
        handler.sendMessage(msg)

    }
}
