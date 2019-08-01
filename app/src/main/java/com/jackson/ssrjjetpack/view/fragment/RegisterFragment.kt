package com.jackson.ssrjjetpack.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jackson.ssrjjetpack.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RegisterFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RegisterFragment : Fragment() ,AnkoLogger{

    private var rootView: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_register, container, false)
            initView()


        }
        return rootView

    }

    private fun initView(){
        info("name："+arguments!!.getString("name")+" - age:"+ arguments!!.getInt("age"))
    }



}
