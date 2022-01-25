package com.example.coffeeapp.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.coffeeapp.R;

public class DetailsCoffeeActivity extends AppCompatActivity {
    private ImageView imageDetail;
    private TextView detailTittle;
    private TextView detailPrice;
    private TextView detailId;
    private ImageView backDetail;

    //metodo para cargar la vista detalle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.coffee_detail);

        imageDetail = findViewById(R.id.imageDetail);
        detailTittle = findViewById(R.id.detailTittle);
        detailPrice = findViewById(R.id.detailPrice);
        detailId = findViewById(R.id.detailId);
        backDetail = findViewById(R.id.backDetail);

        //se llama el metodo dataDetail
        dataDetail();
        //volver al menu principal
        backDetail();
    }
    //se captura los detalles de las tarjetas
    public void dataDetail() {
        String title = getIntent().getStringExtra("Title");
        detailTittle.setText(title);
        String price = getIntent().getStringExtra("Estado");
        detailPrice.setText(price);
        String id = getIntent().getStringExtra("Id");
        detailId.setText(id);

        String image = getIntent().getStringExtra("Imagen");
        Glide.with(this).load(image).into(imageDetail);
    }

    public void backDetail() {

        backDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
