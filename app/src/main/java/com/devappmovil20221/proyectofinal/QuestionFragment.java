package com.devappmovil20221.proyectofinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionFragment extends Fragment {

    private TextView mNombreTextView;
    private TextView mTextoTextView;
    private TextView mPreguntaTextView;
    private TextView mres1TV;
    private TextView mres2TV;
    private TextView mres3TV;
    private TextView mres4TV;
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
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        mNombreTextView = view.findViewById(R.id.nombre_TextView);
        mTextoTextView = view.findViewById(R.id.texto_TextView);
        mPreguntaTextView = view.findViewById(R.id.pregunta_TextView);
        mres1TV = view.findViewById(R.id.res1);
        mres2TV = view.findViewById(R.id.res2);
        mres3TV = view.findViewById(R.id.res3);
        mres4TV = view.findViewById(R.id.res4);
        mres1button = view.findViewById(R.id.res1btn);
        mres2button = view.findViewById(R.id.resdosbtn);
        mres3button = view.findViewById(R.id.restresbtn);
        mres4button = view.findViewById(R.id.rescuatrobtn);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        ContenidoPregunta pregunta = new ContenidoPregunta();
        DatabaseHelper db=new DatabaseHelper(getContext());

        pregunta = db.getPregunta(MainActivity.preguntaActual);

        mNombreTextView.setText(pregunta.getNombre());
        mTextoTextView.setText(pregunta.getTexto());
        mPreguntaTextView.setText(pregunta.getPregunta());
        mres1TV.setText(pregunta.getRes1());
        mres2TV.setText(pregunta.getRes2());
        mres3TV.setText(pregunta.getRes3());
        mres4TV.setText(pregunta.getRes4());
        int res1next = pregunta.getRes1next();
        ContenidoPregunta finalPregunta = pregunta;
        mres1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.preguntaActual=res1next;
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SecondFragment(), null).commit();
            }
        });
        mres2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.preguntaActual=finalPregunta.getRes2next();
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SecondFragment(), null).commit();
            }
        });
        mres3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.preguntaActual=finalPregunta.getRes3next();
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SecondFragment(), null).commit();
            }
        });
        mres4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.preguntaActual=finalPregunta.getRes4next();
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SecondFragment(), null).commit();
            }
        });
    }
}