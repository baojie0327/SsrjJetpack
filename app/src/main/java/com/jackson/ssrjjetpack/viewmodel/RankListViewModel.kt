package com.jackson.ssrjjetpack.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.jackson.ssrjjetpack.R
import com.jackson.ssrjjetpack.databinding.FragmentRankListBinding
import com.jackson.ssrjjetpack.view.activity.EventBusActivity
import com.jackson.ssrjjetpack.view.activity.RoomUseActivity
import com.jackson.ssrjjetpack.view.fragment.RankListFragment
import org.jetbrains.anko.support.v4.startActivity


/*
* RankListViewModel  2019-09-16
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 09 16
*/
class RankListViewModel : ViewModel() {

    private lateinit var mRankListFragment: RankListFragment
    private lateinit var mFragmentRankListBinding: FragmentRankListBinding


    /**
     * 初始化界面
     */
    fun initView() {

        val titleViewModel: TitleViewModel = TitleViewModel()
        titleViewModel.title = "排行"
        mFragmentRankListBinding.titleViewModel = titleViewModel

    }


    fun viewOnClick(view: View) {
        when(view.id){
            R.id.room_use-> mRankListFragment.startActivity<RoomUseActivity>()
            R.id.btn_eventbus-> mRankListFragment.startActivity<EventBusActivity>()
        }
    }


    /**
     * 设置View
     */
    fun setView(rankListFragment: RankListFragment) {
        mRankListFragment = rankListFragment
    }

    fun setBinding(fragmentRankListBinding: FragmentRankListBinding) {
        mFragmentRankListBinding = fragmentRankListBinding
    }
}