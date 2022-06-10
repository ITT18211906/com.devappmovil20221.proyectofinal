package com.devappmovil20221.proyectofinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ResultFragment extends Fragment {

    private TextView mResultHeaderTextView;
    private TextView mResultTextView;
    private Button mExitButton;

    public ResultFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        mResultTextView = view.findViewById(R.id.result_TextView);
        mExitButton = view.findViewById(R.id.button);
        mResultTextView.setText(String.valueOf(MainActivity.preguntaActual - 9000));
        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
        return view;
    }
}