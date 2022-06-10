package com.devappmovil20221.proyectofinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends Fragment {

    public SecondFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        if(MainActivity.preguntaActual < 9000){
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new QuestionFragment(), null).commit();
        }else{
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ResultFragment(), null).commit();
        }
        return view;
    }
}