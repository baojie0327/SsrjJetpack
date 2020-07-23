package com.jackson.ssrjjetpack.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.jackson.ssrjjetpack.R
import com.jackson.ssrjjetpack.databinding.FragmentRankListBinding
import com.jackson.ssrjjetpack.viewmodel.RankListViewModel


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RankListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RankListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RankListFragment : Fragment() {

    private lateinit var mRankListViewModel: RankListViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentRankListBinding: FragmentRankListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_rank_list, null, false)

        mRankListViewModel= ViewModelProviders.of(this).get(RankListViewModel::class.java)
        mRankListViewModel.setView(this)
        mRankListViewModel.setBinding(fragmentRankListBinding)
        fragmentRankListBinding.rankListViewModel=mRankListViewModel
        mRankListViewModel.initView()

        return fragmentRankListBinding.root

    }
}
