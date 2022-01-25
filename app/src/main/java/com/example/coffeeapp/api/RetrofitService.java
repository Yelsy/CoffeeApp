package com.example.coffeeapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static final String URL_001 = "https://61e8f2997ced4a00172ff71b.mockapi.io/api/v1/";

    public static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL_001).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
