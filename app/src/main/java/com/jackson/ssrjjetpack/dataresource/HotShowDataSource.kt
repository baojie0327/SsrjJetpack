package com.jackson.ssrjjetpack.dataresource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import androidx.paging.PositionalDataSource
import com.jackson.ssrjjetpack.apiservice.JsNetworkService
import com.jackson.ssrjjetpack.apiservice.RetrofitClient
import com.jackson.ssrjjetpack.model.HotShowBean
import com.jackson.ssrjjetpack.utils.Constant
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/*
* HotShowDataSource  2019-08-26
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 08 26
*/
class HotShowDataSource : PageKeyedDataSource<Int,HotShowBean.SubjectsBean>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, HotShowBean.SubjectsBean>) {
        getData(0,5,object :MyCallback{
            override fun onSuccess(value: HotShowBean) {
              callback.onResult(value.subjects!!,0,0)
            }

        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, HotShowBean.SubjectsBean>) {
        getData(params.key+5,5,object :MyCallback{
            override fun onSuccess(value: HotShowBean) {
                callback.onResult(value.subjects!!,params.key+5)
            }

        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, HotShowBean.SubjectsBean>) {

    }

    private val mJsNetworkService: JsNetworkService = JsNetworkService(RetrofitClient(Constant.baseUrl))


   /* override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<HotShowBean.SubjectsBean>) {
        getData(params.startPosition,params.loadSize,object:MyCallback{
            override fun onSuccess(value: HotShowBean) {
                if (value.start+value.subjects!!.size<=value.total){
                    value.subjects?.forEach({
                        Log.d("hbj","title="+it.title)
                    })
                    callback.onResult(value.subjects!!)
                }

        }

        })

    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<HotShowBean.SubjectsBean>) {
        getData(0,params.pageSize,object :MyCallback{
            override fun onSuccess(value: HotShowBean) {
                value.subjects?.forEach({
                    Log.d("hbj","title==="+it.title)
                })
               callback.onResult(value.subjects!!,0,value.total)
            }

        })
      // callback.onResult(getData(0,10),0,100)
    }*/


    /**
     * 获取请求参数
     */
    private fun getParaMap(start:Int,count:Int): MutableMap<String, String> {
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
    private fun getData(start:Int,count:Int,myCallback:MyCallback) {

        val paraMap: MutableMap<String, String> = getParaMap(start,count)

         mJsNetworkService.getNetworkService()
            .getHotShowData1(paraMap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object:Observer<HotShowBean>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: HotShowBean) {
                    myCallback.onSuccess(t)
                }

                override fun onError(e: Throwable) {

                }

            })


    }


    private interface MyCallback{
        fun onSuccess(value:HotShowBean)
    }

}