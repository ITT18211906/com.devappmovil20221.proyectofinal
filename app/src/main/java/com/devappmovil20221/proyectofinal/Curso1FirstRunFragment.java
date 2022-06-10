package com.devappmovil20221.proyectofinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Curso1FirstRunFragment extends Fragment {

    public Curso1FirstRunFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        MainActivity.preguntaActual=1001;
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SecondFragment(), null).commit();
        return view;
    }
}