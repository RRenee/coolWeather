package com.example.renee.helloworld.util;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        System.out.println("client");
        Request request = new Request.Builder().url(address).build();
        System.out.println("request");
        client.newCall(request).enqueue(callback);
    }
}
