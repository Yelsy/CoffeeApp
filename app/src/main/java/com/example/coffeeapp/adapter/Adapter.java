package com.example.coffeeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;
import com.example.coffeeapp.ImageRequester;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.Coffee;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Coffee> coffeeList;

    ImageRequester imageRequester;

    public Adapter(ArrayList<Coffee> coffeeList) {
        imageRequester = ImageRequester.getInstance();
        this.coffeeList = coffeeList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from( viewGroup.getContext()).inflate(R.layout.coffee_card, viewGroup, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Coffee coffee = coffeeList.get(position);
        holder.titleTextView.setText(coffee.getTitle());
        imageRequester.setImageFromUrl(holder.photoImageView, coffee.getImage());


    }

    @Override
    public int getItemCount()  {

        return coffeeList.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        NetworkImageView photoImageView;
        TextView titleTextView;

        public ViewHolder(View itemView){
            super(itemView);
            photoImageView=itemView.findViewById(R.id.photoImageView);
            titleTextView=itemView.findViewById(R.id.titleTextView);

        }
    }
}

