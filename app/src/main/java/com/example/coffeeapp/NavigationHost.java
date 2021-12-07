package com.example.coffeeapp;

import androidx.fragment.app.Fragment;

public interface NavigationHost {
    /*
     * disparador de navigacion de un fragmento especifico especifico y adicionalmente  puede ir hacia atras
     * puedo hacer que este stack sea reversible
     */
    void navigateTo(Fragment fragment, boolean addToBackstack);
}
