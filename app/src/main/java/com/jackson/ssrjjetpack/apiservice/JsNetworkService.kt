package com.jackson.ssrjjetpack.apiservice


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

    }

}