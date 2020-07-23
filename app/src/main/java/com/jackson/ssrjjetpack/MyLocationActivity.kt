package com.jackson.ssrjjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jackson.ssrjjetpack.callback.MyLocationListener
import com.jackson.ssrjjetpack.utils.MyBean
import org.jetbrains.anko.toast

class MyLocationActivity : AppCompatActivity() {

    private lateinit var myLocationListener: MyLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_location)

        myLocationListener = MyLocationListener(this) {

        }

        val myBean = MyBean()
        myBean.testCall {
            toast(it)
        }
    }

    override fun onStart() {
        super.onStart()
        myLocationListener.start()
    }

    override fun onStop() {
        super.onStop()
        myLocationListener.stop()
    }
}
