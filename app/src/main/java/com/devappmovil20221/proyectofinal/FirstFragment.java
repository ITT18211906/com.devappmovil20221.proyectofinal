package com.devappmovil20221.proyectofinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class FirstFragment extends Fragment {
    // Declaracion de variables miembro
    private ImageButton mimagebutton_curso1;

    public FirstFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mimagebutton_curso1 = view.findViewById(R.id.imagebutton_curso1);
        mimagebutton_curso1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SecondFragment(), null).commit();
            }
        });
        return view;
    }
}