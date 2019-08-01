package com.jackson.ssrjjetpack.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.jackson.ssrjjetpack.R
import com.jackson.ssrjjetpack.view.LoginActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity


class MineFragment : Fragment(),View.OnClickListener {

    private var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_mine, container, false)
            initView()

        }
        return rootView
    }

    private fun initView() {
        // 方法二
        //  rootView!!.find<Button>(R.id.btn_register).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.registerFragment,null))
        rootView!!.find<Button>(R.id.btn_register).setOnClickListener(this)
        rootView!!.find<Button>(R.id.btn_login).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            // 方法一
            R.id.btn_register -> {
                val bundle= bundleOf("name" to "Jackson","age" to 18)
                Navigation.findNavController(rootView!!).navigate(R.id.action_mineFragment_to_registerFragment,bundle)
            }
            R.id.btn_login ->startActivity<LoginActivity>()

        }
    }

}
