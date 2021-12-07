package com.example.coffeeapp;

import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CoffeeCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView coffeeImage;
    public TextView coffeeTitle;
    public TextView coffeePrice;

    public CoffeeCardViewHolder(@NonNull View itemView) {
        super(itemView);
        coffeeImage = itemView.findViewById(R.id.coffee_image);
        coffeeTitle = itemView.findViewById(R.id.coffee_title);
        coffeePrice = itemView.findViewById(R.id.coffee_price);
    }
}
