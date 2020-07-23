package com.jackson.ssrjjetpack.view.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import com.jackson.ssrjjetpack.R
import com.jackson.ssrjjetpack.room.Address
import com.jackson.ssrjjetpack.room.AppDatabase
import com.jackson.ssrjjetpack.room.User
import com.jackson.ssrjjetpack.room.UserDao
import com.jackson.ssrjjetpack.utils.MessageEvent
import kotlinx.android.synthetic.main.activity_room_use.*
import org.greenrobot.eventbus.EventBus

class RoomUseActivity : AppCompatActivity() {

    private var number = 0

    lateinit var userDao: UserDao

    val handler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            tv_show.text = msg?.obj as String

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_use)
        userDao = AppDatabase.getInstance(this).userDao()



        btn_add.setOnClickListener {
            addUser()
        }

        btn_query.setOnClickListener {
            query()
        }

        btn_update.setOnClickListener {
            update()
        }

        btn_delete.setOnClickListener {
            delete()
        }


    }

    private fun addUser() {
        Thread(Runnable {
            val user = User()
            user.firstName = "赵"
            user.lastName = "云"
            val address = Address()
            address.street = "常山"
            address.city = "成都"
            address.state = "蜀汉"
            address.postCode = 10010
            user.address = address
            userDao.insertUser(user)
        }).start()

    }

    private fun query() {
        val stringBuilder = StringBuffer()
        Thread(Runnable {
            val userList = userDao.getAll()
            for (user in userList) {
                stringBuilder.append(user.uid)
                    .append(" ")
                    .append(user.firstName)
                    .append(" ")
                    .append(user.lastName)
                    .append(" \n")
                    .append(user.address?.state)
                    .append(" ")
                    .append(user.address?.city)
                    .append(" ")
                    .append(user.address?.street)
                    .append(" ")
                    .append(user.address?.postCode)
                    .append(" \n")
            }
            val message = Message.obtain(handler)
            message.obj = stringBuilder.toString()
            handler.sendMessage(message)
        }).start()

    }


    private fun update() {
        Thread(Runnable {
            val user = User()
            user.uid = 4
            user.firstName = "李"
            userDao.update(user)
        }).start()
    }

    private fun delete() {
        Thread(Runnable {
            val user = User()
            user.uid=2
            userDao.delete(user)
        }).start()
    }


}
