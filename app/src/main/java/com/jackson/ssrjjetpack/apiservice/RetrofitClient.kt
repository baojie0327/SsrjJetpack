package com.jackson.ssrjjetpack.apiservice

import com.jackson.ssrjjetpack.BuildConfig
import com.jackson.ssrjjetpack.utils.Constant
import com.jackson.ssrjjetpack.utils.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.*


/*
* RetrofitClient  2019-07-25
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* Retrofit客户端类
* @author Jackson
* @version 1.0.0
* since 2019 07 25
*/
class RetrofitClient(baseUrl: String) {

    private var mRetrofit: Retrofit

    init {
        // 拦截器
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        // OkHttp 设置信任所有的证书
        val trustManager = object : X509TrustManager {

            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) = Unit

            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) = Unit

            override fun getAcceptedIssuers(): Array<X509Certificate?> = arrayOfNulls(0)

        }

        var sslContext: SSLContext? = null
        try {
            sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, arrayOf<TrustManager>(trustManager), SecureRandom())
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: KeyManagementException) {
            e.printStackTrace()
        }

        var DO_NOT_VERIFY = HostnameVerifier { hostname, session -> true }

        //创建okHttpClient
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .sslSocketFactory(sslContext!!.socketFactory, trustManager)
            .hostnameVerifier(DO_NOT_VERIFY)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .build()

        // 创建Retrofit2的实例，并设置BaseUrl和Gson转换
        mRetrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create()) // 支持String
            .addConverterFactory(GsonConverterFactory.create())    //设置 Json 转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //RxJava 适配器
            .addCallAdapterFactory(LiveDataCallAdapterFactory())  //LiveData 适配器
            .client(okHttpClient)
            .build()

    }

    /**
     * 创建Retrofit请求服务   ApiService apiService = retrofit.create(ApiService.class);
     *   Class<T> object来传递类的class对象
     * @param
     * @param
     * @return
     */
    fun <T> create(apiInterfaceClass:Class<T>):T=mRetrofit.create(apiInterfaceClass)


}