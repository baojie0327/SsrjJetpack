package com.jackson.ssrjjetpack.dataresource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.jackson.ssrjjetpack.model.HotShowBean


/*
* HotShowDataSourceFactory  2019-08-28
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 28
*/
class HotShowDataSourceFactory: DataSource.Factory<Int, HotShowBean.SubjectsBean>() {

     var dataList:MutableLiveData<HotShowDataSource> = MutableLiveData()

    override fun create(): DataSource<Int, HotShowBean.SubjectsBean>{
        val hotShowDataSource=HotShowDataSource()
        dataList.postValue(hotShowDataSource)
        return hotShowDataSource
    }
}