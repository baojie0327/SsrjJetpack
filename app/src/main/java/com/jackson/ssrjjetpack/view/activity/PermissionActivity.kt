package com.jackson.ssrjjetpack.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.jackson.ssrjjetpack.BaseActivity
import com.jackson.ssrjjetpack.callback.LifecycleCallback
import com.jackson.ssrjjetpack.callback.MyObserver
import com.jackson.ssrjjetpack.R
import com.jackson.ssrjjetpack.callback.EventBusObserver

import com.jackson.ssrjjetpack.utils.MessageEvent
import com.jackson.ssrjjetpack.utils.PermissionUtils
import com.jackson.ssrjjetpack.utils.PermissionUtils.PERMISSION_CODE
import kotlinx.android.synthetic.main.activity_permission.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import timber.log.Timber
import java.time.chrono.IsoEra

class PermissionActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        request_permission.setOnClickListener {
            applyPermission()
        }




    }

    @AfterPermissionGranted(PERMISSION_CODE)
    fun applyPermission() {
        if (hasPermissions(*PermissionUtils.requestPermissions)) {
            toast("有权限")
        } else {
            EasyPermissions.requestPermissions(
                this, getString(R.string.permission),
                PERMISSION_CODE,
                *PermissionUtils.requestPermissions
            )
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {

            toast(
                getString(
                    R.string.return_from_app_setting,
                   if (hasPermissions(PermissionUtils.READ_EXTERNAL_STORAGE, PermissionUtils.WRITE_EXTERNAL_STORAGE)) "是" else "否",
                    if (hasPermissions(PermissionUtils.CAMERA)) "是" else "否",
                    if (hasPermissions(PermissionUtils.ACCESS_FINE_LOCATION, PermissionUtils.ACCESS_COARSE_LOCATION)) "是" else "否")
            )

        }
    }




}
