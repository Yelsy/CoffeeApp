package com.example.coffeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InicioCoffee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_coffee);
    }

    public void goLogin(View view){
        Intent intent= new Intent(this,LoginFragment.class);
        startActivity(intent);
    }
}
