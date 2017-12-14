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

    // Aqui debo poner las opcines de reproduccion del grafo actual
    Button btnVolver_ReproduccionGrafo, btnEscuchargrafocompleto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcines_reproduccion_grafo);

        btnEscuchargrafocompleto = (Button) findViewById(R.id.btnEscuchargrafocompleto);
        btnVolver_ReproduccionGrafo = (Button) findViewById(R.id.btnVolver_ReproduccionGrafo);

        Globals g = Globals.getInstance();
        final int idGlobalPlay = g.getIdGlobalPlay(); // obtengo el id del grafo actual para reproducir
        

        btnEscuchargrafocompleto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Mi idea en esta instancia es, tener una clase que posee varias funciones que permitan,
                // pasar a string lo que se les pase como parametro.
                // compilar todito el grafo almacenado en la base de datos y devolverlo en string, para su
                // posterior reproduccion.

                // Por otro lado me gustaria tener una clase Play, la cual posea metodos que tomen un string y lo reproduscan.
                // por el momento una reproduccion simple no mas.

                // final Play p = new Play();
                // final ConstructionGraph c = new ConstructionGraph();



            }
        });

        btnVolver_ReproduccionGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListPlay.class));
            }
        });

    }

}
