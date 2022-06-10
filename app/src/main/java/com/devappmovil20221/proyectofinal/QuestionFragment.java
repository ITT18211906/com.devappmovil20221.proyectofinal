package com.devappmovil20221.proyectofinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class QuestionFragment extends Fragment {

    private TextView mNombreTextView;
    private TextView mTextoTextView;
    private TextView mPreguntaTextView;
    private Button mres1button;
    private Button mres2button;
    private Button mres3button;
    private Button mres4button;

    public QuestionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        mNombreTextView = view.findViewById(R.id.nombre_TextView);
        mTextoTextView = view.findViewById(R.id.texto_TextView);
        mPreguntaTextView = view.findViewById(R.id.pregunta_TextView);
        mres1button = view.findViewById(R.id.res1);
        mres2button = view.findViewById(R.id.res2);
        mres3button = view.findViewById(R.id.res3);
        mres4button = view.findViewById(R.id.res4);

        ContenidoPregunta pregunta = new ContenidoPregunta();
        DatabaseHelper db=new DatabaseHelper(getContext());

        pregunta = db.getPregunta(MainActivity.preguntaActual);

        mNombreTextView.setText(pregunta.getNombre());
        mTextoTextView.setText(pregunta.getTexto());
        mPreguntaTextView.setText(pregunta.getPregunta());
        mres1button.setText(pregunta.getRes1());
        mres2button.setText(pregunta.getRes2());
        mres3button.setText(pregunta.getRes3());
        mres4button.setText(pregunta.getRes4());
        ContenidoPregunta finalPregunta = pregunta;
        mres1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.preguntaActual= finalPregunta.getRes1next();
            }
        });
        mres2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.preguntaActual=finalPregunta.getRes2next();
            }
        });
        mres3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.preguntaActual=finalPregunta.getRes3next();
            }
        });
        mres4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.preguntaActual=finalPregunta.getRes4next();
            }
        });
        return view;
    }
}