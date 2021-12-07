package com.example.coffeeapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeeapp.network.ImageRequester;
import com.example.coffeeapp.network.CoffeeEntry;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class CoffeeCardRecyclerView extends RecyclerView.Adapter<CoffeeCardViewHolder> {

    private List<CoffeeEntry> coffeeList;
    private ImageRequester imageRequester;

    CoffeeCardRecyclerView(List<CoffeeEntry> coffeeList) {
        this.coffeeList = coffeeList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public CoffeeCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_card, parent, false);
        return new CoffeeCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeCardViewHolder holder, int position) {
        if (coffeeList != null && position < coffeeList.size()) {
            CoffeeEntry coffee = coffeeList.get(position);
            holder.coffeeTitle.setText(coffee.tittle);
            holder.coffeePrice.setText(coffee.price);
            imageRequester.setImageFromUrl(holder.coffeeImage, coffee.url);
        }
    }
    @Override
    public int getItemCount() {
        return coffeeList.size();
    }
}
