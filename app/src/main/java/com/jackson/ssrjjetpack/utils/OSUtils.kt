package com.jackson.ssrjjetpack.utils


import android.os.Build
import android.text.TextUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


/*
* OSUtils  2019-07-23
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 07 23
*/
object OSUtils {

    private val ROM_MIUI = "MIUI"
    private val ROM_EMUI = "EMUI"
    private val ROM_FLYME = "FLYME"
    private val ROM_OPPO = "OPPO"
    private val ROM_SMARTISAN = "SMARTISAN"
    private val ROM_VIVO = "VIVO"
    private val ROM_QIKU = "QIKU"
    private val KEY_VERSION_MIUI:String = "ro.miui.ui.version.name"
    private val KEY_VERSION_EMUI = "ro.build.version.emui"
    private val KEY_VERSION_OPPO = "ro.build.version.opporom"
    private val KEY_VERSION_SMARTISAN = "ro.smartisan.version"
    private val KEY_VERSION_VIVO = "ro.vivo.os.version"
    private var sName: String? = null
    private var sVersion: String? = null

    fun isEmui(): Boolean {
        return check(ROM_EMUI)
    }

    fun isMiui(): Boolean {
        return check(ROM_MIUI)
    }

    fun isVivo(): Boolean {
        return check(ROM_VIVO)
    }

    fun isOppo(): Boolean {
        return check(ROM_OPPO)
    }

    fun isFlyme(): Boolean {
        return check(ROM_FLYME)
    }

    fun is360(): Boolean {
        return check(ROM_QIKU) || check(
            "360"
        )
    }

    fun isSmartisan(): Boolean {
        return check(ROM_SMARTISAN)
    }

    fun getName(): String? {
        if (sName == null) {
            check("")
        }
        return sName
    }

    fun getVersion(): String? {
        if (sVersion == null) {
            check("")
        }
        return sVersion
    }

    fun check(rom: String): Boolean {
        if (sName != null) {
            return sName == rom
        }
        if (!TextUtils.isEmpty(getProp(KEY_VERSION_MIUI))) {
            sVersion =
                getProp(KEY_VERSION_MIUI)
            sName = ROM_MIUI
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_EMUI))) {
            sVersion =
                getProp(KEY_VERSION_EMUI)
            sName = ROM_EMUI
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_OPPO))) {
            sVersion =
                getProp(KEY_VERSION_OPPO)
            sName = ROM_OPPO
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_VIVO))) {
            sVersion =
                getProp(KEY_VERSION_VIVO)
            sName = ROM_VIVO
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_SMARTISAN))) {
            sVersion =
                getProp(KEY_VERSION_SMARTISAN)
            sName = ROM_SMARTISAN
        } else {
            sVersion = Build.DISPLAY
            if (sVersion!!.toUpperCase().contains(ROM_FLYME)) {
                sName = ROM_FLYME
            } else {
                sVersion = Build.UNKNOWN
                sName = Build.MANUFACTURER.toUpperCase()
            }
        }
        return sName == rom
    }

    fun getProp(name: String): String? {
        var line: String? = null
        var input: BufferedReader? = null
        try {
            val p = Runtime.getRuntime().exec("getprop $name")
            input = BufferedReader(InputStreamReader(p.inputStream), 1024)
            line = input!!.readLine()
            input!!.close()
        } catch (ex: IOException) {
            return null
        } finally {
            if (input != null) {
                try {
                    input!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
        return line
    }
}