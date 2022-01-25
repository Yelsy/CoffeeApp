package com.example.coffeeapp.api;

import com.example.coffeeapp.model.Coffee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {
    //obtiene las tarjetas para mostrarlas en el menu
    @GET("Coffee")
    Call<List<Coffee>> getListCoffee();

    @POST("Coffee")
    Call<Coffee> insertProduct(@Body Coffee coffee);

}
