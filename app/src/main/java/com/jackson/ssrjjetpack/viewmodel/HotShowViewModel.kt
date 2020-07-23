package com.jackson.ssrjjetpack.viewmodel

import android.graphics.Color
import android.view.View.OnClickListener
import android.view.View.VISIBLE
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.jackson.ssrjjetpack.adapter.HotShowAdapter
import com.jackson.ssrjjetpack.adapter.HotShowPagingAdapter
import com.jackson.ssrjjetpack.apiservice.JsNetworkService
import com.jackson.ssrjjetpack.apiservice.RetrofitClient
import com.jackson.ssrjjetpack.databinding.FragmentHotShowBinding
import com.jackson.ssrjjetpack.dataresource.HotShowDataSourceFactory
import com.jackson.ssrjjetpack.model.HotShowBean
import com.jackson.ssrjjetpack.utils.Constant
import com.jackson.ssrjjetpack.view.activity.PermissionActivity
import com.jackson.ssrjjetpack.view.fragment.HotShowFragment
import io.reactivex.Flowable
import org.jetbrains.anko.support.v4.startActivity


/*
* HotShowViewModel  2019-08-02
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 02
*/
class HotShowViewModel : ViewModel() {


    private val mJsNetworkService: JsNetworkService = JsNetworkService(RetrofitClient(Constant.baseUrl))
    private lateinit var mHotShowFragment: HotShowFragment
    private lateinit var mFragmentHotShowBinding: FragmentHotShowBinding
    private lateinit var mHotShowAdapter: HotShowAdapter
    private lateinit var mHotShowPagingAdapter: HotShowPagingAdapter

    private val hotShowDataSourceFactory = HotShowDataSourceFactory()

    //  paging
    var movieDataList: LiveData<PagedList<HotShowBean.SubjectsBean>> = LivePagedListBuilder(hotShowDataSourceFactory,
        PagedList.Config.Builder()
            .setPageSize(5)                //配置分页加载的数量
            .setEnablePlaceholders(false)  //配置是否启动PlaceHolders
            //  .setInitialLoadSizeHint(5)    //初始化加载的数量
            .build()).build()
  //  private var hotShowDataSource: DataSource<Int, HotShowBean.SubjectsBean>
    lateinit var hotShowPagingAdapter: HotShowPagingAdapter

    init {
//        val hotShowDataSourceFactory = HotShowDataSourceFactory()
//        hotShowDataSource = hotShowDataSourceFactory.create()
//        val config: PagedList.Config = PagedList.Config.Builder()
//            .setPageSize(30)                //配置分页加载的数量
//            .setEnablePlaceholders(false)  //配置是否启动PlaceHolders
//          //  .setInitialLoadSizeHint(5)    //初始化加载的数量
//            .build()
//        movieDataList = LivePagedListBuilder(hotShowDataSourceFactory, config).build()

    }

    // 定义数据源
    val movieLiveData: MutableLiveData<HotShowBean>
        get() = getMovieData(0, 100)

    /**
     * 初始化界面
     */
    fun initView() {
        val titleViewModel: TitleViewModel = TitleViewModel()
        titleViewModel.title = "热映"
        titleViewModel.rightTitle = "权限申请"
        mFragmentHotShowBinding.titleViewModel = titleViewModel
        //     mFragmentHotShowBinding.titleViewModel!!.leftIconResId=R.mipmap.withdraw_white
//        mFragmentHotShowBinding.titleViewModel!!.leftClickListener= OnClickListener {
//            Toast.makeText(mHotShowFragment.context,"onClick",Toast.LENGTH_SHORT).show()
//        }
        mFragmentHotShowBinding.header.tvRightTitle.visibility = VISIBLE
        mFragmentHotShowBinding.titleViewModel!!.rightClickListener = OnClickListener {
            mHotShowFragment.startActivity<PermissionActivity>()
        }

        val layoutManger = LinearLayoutManager(mHotShowFragment.context)
        mFragmentHotShowBinding.recyclerView.layoutManager = layoutManger
    }

    /**
     * 更新界面
     */
    fun updateUi(dataList: MutableList<HotShowBean.SubjectsBean>?) {
        if (dataList != null && dataList.size > 0) {
//            mHotShowAdapter = HotShowAdapter(R.layout.item_hotshow_layout,dataList)
//            mFragmentHotShowBinding.recyclerView.adapter=mHotShowAdapter
        }

    }


    /**
     * paging
     */
    fun initPagingData() {
        hotShowPagingAdapter = HotShowPagingAdapter()
        mFragmentHotShowBinding.recyclerView.adapter = hotShowPagingAdapter
    }


    fun refreshData(){
        mFragmentHotShowBinding.swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN)
        mFragmentHotShowBinding.swipeRefreshLayout.setOnRefreshListener {
            hotShowDataSourceFactory.dataList.value?.invalidate()
            mFragmentHotShowBinding.swipeRefreshLayout.isRefreshing=false
        }
    }


    /**
     * 获取请求参数
     */
    private fun getParaMap(start: Int, count: Int): MutableMap<String, String> {
        val paraMap: MutableMap<String, String> = mutableMapOf()
        paraMap["apikey"] = "0df993c66c0c636e29ecbb5344252a4a"
        paraMap["city"] = "北京"
        paraMap["start"] = start.toString()
        paraMap["count"] = count.toString()
        return paraMap
    }

    /**
     * 获取电影数据
     */
    private fun getMovieData(start: Int, count: Int): MutableLiveData<HotShowBean> {
        val paraMap: MutableMap<String, String> = getParaMap(start, count)

        return mJsNetworkService.getNetworkService()
            .getHotShowData(paraMap)


//        movieLiveData=LiveDataReactiveStreams.fromPublisher(
//            mJsNetworkService.getNetworkService()
//                .getHotShowData(paraMap)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//        )


    }


    /**
     * 设置View
     */
    fun setView(hotShowFragment: HotShowFragment) {
        mHotShowFragment = hotShowFragment
    }

    fun setBinding(fragmentHotShowBinding: FragmentHotShowBinding) {
        mFragmentHotShowBinding = fragmentHotShowBinding
    }

    private fun getRxData(lifecycleOwner: LifecycleOwner): Flowable<HotShowBean> {
        return Flowable.fromPublisher(LiveDataReactiveStreams.toPublisher(lifecycleOwner, movieLiveData))
    }


}


