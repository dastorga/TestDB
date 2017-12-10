package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Opciones de reproduccion del grafo seleccionado.
 */

public class OpcionesReproduccionGrafo extends AppCompatActivity {

    // Aqui debo poner las opcines dereproduccion del grafo actual
    Button btnVolver_ReproduccionGrafo, btnEscuchargrafocompleto, test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcines_reproduccion_grafo);

        btnEscuchargrafocompleto = (Button) findViewById(R.id.btnEscuchargrafocompleto);
        test = (Button) findViewById(R.id.test);
        btnVolver_ReproduccionGrafo = (Button) findViewById(R.id.btnVolver_ReproduccionGrafo);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        Globals g = Globals.getInstance();
        int idGlobalPlay = g.getIdGlobalPlay(); // obtengo el id del grafo actual para reproducir

        btnEscuchargrafocompleto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        btnVolver_ReproduccionGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListPlay.class));
            }
        });

    }

}
