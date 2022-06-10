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

        DatabaseHelper db=new DatabaseHelper(getContext());
        db.manualRenewDB();
        db.addPregunta(1001, "¿Que es Factura?", "Una factura es un documento de carácter mercantil que refleja la compraventa de un bien o la prestación de un servicio determinado.", "¿Como se representa una factura en Máxico?", "Sello Digital", 2001, "Copia Oficial", 2002, "XML y PDF", 2001, "Sello y Firma", 2002);

        MainActivity.preguntaActual=1001;
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SecondFragment(), null).commit();
        return view;
    }
}