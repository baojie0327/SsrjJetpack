package com.jackson.ssrjjetpack.utils

import android.Manifest


/*
* PermissionUtils  2019-08-15
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 15
*/
object PermissionUtils {

    const val PERMISSION_CODE = 0  // 写外部存储
    val CAMERA_CODE = 1  // 相册权限

     const val READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE  // 读外部存储
     const val WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE // 写外部存储
     const val CAMERA = Manifest.permission.CAMERA                                 // 照相机权限
     const val ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION      // GPS位置权限
     const val ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION  // wifi和移动基站位置权限

    val requestPermissions = arrayOf(
        READ_EXTERNAL_STORAGE,
        WRITE_EXTERNAL_STORAGE,
        CAMERA,
        ACCESS_FINE_LOCATION,
        ACCESS_COARSE_LOCATION
    )

}