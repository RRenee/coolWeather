package com.example.renee.helloworld.util;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ApiServer {
    @POST("shopping_login.htm")
    Observable<String> LoginByRx(@Field("userName") String userName, @Field("passWord") String passWord);
}
