package com.example.coffeeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements NavigationHost{

    BottomNavigationView bottonNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, new LoginFragment()).commit();
        }

        setContentView(R.layout.activity_main);
        bottonNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottonNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.special_menu) {
                    navigateTo(new CoffeeGridFragment(),true);
                }else if(menuItem.getItemId() == R.id.camera_menu){
                    navigateTo(new CameraFragment(),true);
                }

                return true;
            }
        });



    }
    private void showSelectedFragment(Fragment fragment){

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

    }


    @Override
    public void navigateTo(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment);
        if(addToBackStack == true){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


   @Override
   public void hideShowFragment(androidx.fragment.app.Fragment oldFragment, androidx.fragment.app.Fragment newFragment, String tag) {

   }

}