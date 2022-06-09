package com.devappmovil20221.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // Llamamos al administrador de fragmentos
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragment_container) != null){
            // Sobrepone los fragmentos en caso de que no
            if (savedInstanceState != null){
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.add(R.id.fragment_container, firstFragment, null);
            fragmentTransaction.commit();
        }
    }
}