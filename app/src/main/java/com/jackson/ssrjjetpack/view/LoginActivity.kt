package com.jackson.ssrjjetpack.view

import android.os.Bundle
import com.jackson.ssrjjetpack.BaseActivity
import com.jackson.ssrjjetpack.R

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       initAppBar(1)
    }
}
