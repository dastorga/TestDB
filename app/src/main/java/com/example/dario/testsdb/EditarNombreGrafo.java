package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EditarNombreGrafo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_nombre_grafo);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

    }
}