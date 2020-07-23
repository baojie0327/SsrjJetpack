package com.jackson.ssrjjetpack.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jackson.ssrjjetpack.R
import com.jackson.ssrjjetpack.databinding.FragmentHotShowBinding
import com.jackson.ssrjjetpack.viewmodel.HotShowViewModel
import timber.log.Timber


class HotShowFragment : Fragment() {

    //  private var rootView: View? = null
    private lateinit var mHotShowViewModel: HotShowViewModel



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //   if (rootView == null) {

        //   rootView = inflater.inflate(R.layout.fragment_hot_show, container, false)

        val fragmentHotShowBinding: FragmentHotShowBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_hot_show, null, false)

        mHotShowViewModel = ViewModelProviders.of(this).get(HotShowViewModel::class.java)
        mHotShowViewModel.setView(this)
        mHotShowViewModel.setBinding(fragmentHotShowBinding)
        fragmentHotShowBinding.hotShowViewModel=mHotShowViewModel

        mHotShowViewModel.initView()

      /*  mHotShowViewModel.movieLiveData.observe(this, Observer {
            // 更新界面
            Timber.w(it.subjects?.get(0)?.title)
            mHotShowViewModel.updateUi(it.subjects)
        })*/

        // paging
        mHotShowViewModel.initPagingData()
        mHotShowViewModel.movieDataList.observe(this, Observer(mHotShowViewModel.hotShowPagingAdapter::submitList))

        mHotShowViewModel.refreshData()

        return fragmentHotShowBinding.root

    }



}
