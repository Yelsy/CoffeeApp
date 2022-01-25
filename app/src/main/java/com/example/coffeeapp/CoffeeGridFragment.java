package com.example.coffeeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeeapp.adapter.Adapter;
import com.example.coffeeapp.api.RetrofitService;
import com.example.coffeeapp.api.Service;
import com.example.coffeeapp.model.Coffee;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoffeeGridFragment extends Fragment {

    RecyclerView recycler_view;
    Adapter adapter;
    List<Coffee> coffeeList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle Savedstatecinstantece) {
        View view = inflater.inflate(R.layout.coffee_grid_fragment, parent, false);
        recycler_view = view.findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));


        Service service = RetrofitService.getRetrofit().create(Service.class);
        Call<List<Coffee>> call = service.getListCoffee();
        call.enqueue(new Callback<List<Coffee>>() {
            @Override
            public void onResponse(Call<List<Coffee>> call, Response<List<Coffee>> response) {
                if (response.isSuccessful()) {

                    adapter = new Adapter((ArrayList<Coffee>) response.body());
                    recycler_view.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Coffee>> call, Throwable t) {

                Toast.makeText(getContext(), "Error al conectar con el servicio", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

        //private void setUpToolbar(View view){
        //   Toolbar toolbar = view.findViewById(R.id.bottom_navigation);
        //   AppCompatActivity activity=(AppCompatActivity) getActivity();
        //   if(activity != null){
        //       activity.setSupportActionBar(toolbar);
        //  }


        // }


    }