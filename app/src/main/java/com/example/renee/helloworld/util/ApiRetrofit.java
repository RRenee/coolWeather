package com.example.renee.helloworld.util;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiRetrofit {
    private static int TIME_OUT = 30;

    private static ApiRetrofit apiRetrofit;
    private static Retrofit retrofit;
    private OkHttpClient client;
    private static volatile Request request = null;


    public static ApiRetrofit getInstance(){
        if(apiRetrofit == null){
            synchronized (ApiRetrofit.class){
                if(apiRetrofit == null){
                    apiRetrofit = new ApiRetrofit();
                }
            }
        }
        return apiRetrofit;
    }

    /*
     * 初始化必要对象和参数
     */
    public void init(){
        //初始化okhttp
        client = new OkHttpClient.Builder().build();

        //初始化retrofit
        retrofit = new Retrofit.Builder()
                .client(client).baseUrl(com.example.renee.helloworld.util.Request.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Request getRequest(){
        if(request == null){
            synchronized (Request.class){
                request = retrofit.create(Request.class);
            }
        }
        return request;
    }


}
