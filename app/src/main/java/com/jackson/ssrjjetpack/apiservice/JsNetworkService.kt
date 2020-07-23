package com.jackson.ssrjjetpack.apiservice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jackson.ssrjjetpack.model.HotShowBean
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap


/*
* JsNetworkService  2019-07-30
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* 网络请求工具
* @author Jackson
* @version 1.0.0
* since 2019 07 30
*/
class JsNetworkService(retrofitClient:RetrofitClient) {

    private val mINetworkService:INetworkService

    /**
     * init
     */
    init {
        mINetworkService=retrofitClient.create(JsNetworkService.INetworkService::class.java)
    }

    /**
     * 获取INetworkService实例
     */
    fun getNetworkService():INetworkService=mINetworkService

    interface INetworkService{

        /**
         * 热映
         */
        @GET("v2/movie/in_theaters")
        fun getHotShowData(@QueryMap paramMap: Map<String, String>): MutableLiveData<HotShowBean>


        /**
         * 热映
         */
        @GET("v2/movie/in_theaters")
        fun getHotShowData1(@QueryMap paramMap: Map<String, String>): Observable<HotShowBean>

    }

}