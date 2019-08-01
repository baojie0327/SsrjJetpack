package com.jackson.ssrjjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.jackson.ssrjjetpack.utils.StatusBarUtil
import org.jetbrains.anko.toast

open class BaseActivity : AppCompatActivity() {

  /**  private lateinit var lifecycleRegistry: LifecycleRegistry **/

    private lateinit var myObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**   ComponentActivity  里已经实现了     **/
        /**    lifecycleRegistry= LifecycleRegistry(this)  **/
        /**   lifecycleRegistry.markState(Lifecycle.State.CREATED)  **/

        myObserver= MyObserver(lifecycle,object :LifecycleCallback{
            override fun update(message: String) {
               Log.d("hbj--",message)
            }

        })

        lifecycle.addObserver(myObserver)

    }


    override fun onStart() {
        super.onStart()
      //  lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }


    override fun onResume() {
        super.onResume()
      //  lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    override fun onDestroy() {
        super.onDestroy()
      //  lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }



    /**
     * 设置沉浸式主题
     */
    protected fun initAppBar(type:Int){
        when(type){
            0->{
                //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
                StatusBarUtil.setRootViewFitsSystemWindows(this,true)
                //设置状态栏透明
                StatusBarUtil.setTranslucentStatus(this)
                StatusBarUtil.setStatusBarColor(this, 0xff00BD30.toInt())
            }
            1->{
                StatusBarUtil.setRootViewFitsSystemWindows(this,false)
                StatusBarUtil.setTranslucentStatus(this)
            }
        }

//        if (!StatusBarUtil.setStatusBarDarkTheme(this,true)){
//            StatusBarUtil.setStatusBarColor(this,0xff008577.toInt())
//        }
    }
}
