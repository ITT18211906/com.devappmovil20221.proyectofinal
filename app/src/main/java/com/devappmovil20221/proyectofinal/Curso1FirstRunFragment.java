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
        db.addPregunta(2001, "¿Que es CFDI?", "Sus siglas significan Comprobante Fiscal Digital por Internet, pero también se le conoce como factura electrónica, sin embargo para que ésta sea válida como el comprobante de una transacción debe de cumplir con los requisitos que marca el  art 29-A del Código Fiscal de la Federación (CFF).", "¿Como se representa una factura digital?","Sello Digital",3001,"Copia Oficial",3001,"XML y PDF",4001,"Sello y Firma",3002);
        db.addPregunta(2002, "¿Que es Factura Fiscal?", "Como ya se ha comentado anteriormente, la factura es el medio justificativo de cualquier operación. Cuando una empresa se deduce un IVA soportado o contabiliza como ingreso una operación tiene que poseer las facturas, ya que es el único justificante válido ante una posible inspección de la Agencia Tributaria.", "¿Cuál es la manera adecuada de recibir un pago?","Efectivo",2001,"Transferencia Electrónica",2001,"Tarjeta de Crédito",2001,"Cryptomoneda",9001);
        db.addPregunta(3001,"¿Que es NotaDeCredito?","La nota de crédito es un documento administrativo comercial que tiene validez legal y que puede intervenir en operaciones de compraventa de todo tipo y que tiene como objetivo la modificación posterior a la emisión de la factura.","¿Como la modifica?","Agregando saldo",4001,"Quitando saldo",4002,"Terminos de pago futuro",4002,"Condonación",4002);
        db.addPregunta(4001,"Ingreso vs Egreso","Cuando un CFDI refiere a un ingreso o egreso, este refiere al flujo de efectivo de la empresa emisora del CFDI. En el caso del CFDI Pago, este refiere a un reconocimiento de pago.","Este CFDI equivale a una factura:","Ingreso",4002,"Egreso",9063,"Pago",9045,"XML",9057);
        db.addPregunta(4002,"Prueba de lógica","Si una persona ha dormido 19 horas durante la última semana: ","Cuántas horas a dormido por día","No las suficientes",9085,"Entre 0 y 8",9090,"Mientras que la calificacion salga, tobo bn.",9100,"4ta respuesta",9004);
        MainActivity.preguntaActual=1001;
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SecondFragment(), null).commit();
        return view;
    }
}