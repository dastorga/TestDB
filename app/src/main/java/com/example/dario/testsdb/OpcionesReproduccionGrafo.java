package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Opciones de reproduccion del grafo seleccionado.
 */

public class OpcionesReproduccionGrafo extends AppCompatActivity {

    private Button btnVolver_ReproduccionGrafo, btnEscuchargrafocompleto, btnReproducirNodos;
    ConstructionGraph c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcines_reproduccion_grafo);

        btnEscuchargrafocompleto = findViewById(R.id.btnEscuchargrafocompleto);
        btnReproducirNodos = findViewById(R.id.btnReproducirNodos);
        btnVolver_ReproduccionGrafo = findViewById(R.id.btnVolver_ReproduccionGrafo);

        final Globals g = Globals.getInstance();
        final int idGlobalPlay = g.getIdGlobalPlay(); // Obtengo el id del grafo actual para reproducir

        btnEscuchargrafocompleto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * Mi idea en esta instancia es, tener una clase "ConstructionGraph" que posee varias funciones que permitan,
                 * pasar a string lo que se les pase como parametro.
                 * compilar todito el grafo almacenado en la base de datos y devolverlo en string, para su
                 * posterior reproduccion.

                 * Por otro lado me gustaria tener una clase "Play", la cual posea metodos que tomen un string y lo reproduzcan directamente
                 * en cualquier instancia de la aplicacion donde yo la llame.
                 * Por el momento con una reproduccion simple no mas me alcanza
                 * Luego ver el tema de la longitud de reproduccion y velocidad, y repeticion de la reproduccion.
                 */

                c = new ConstructionGraph(getApplicationContext()); // Paso contexto actual
                String graphCompletString = c.ConstrucctionGraphString(idGlobalPlay);
                Toast.makeText(OpcionesReproduccionGrafo.this, graphCompletString  , Toast.LENGTH_SHORT).show();

                // Me debo ir a la clase Play para reproducir solamente.
                // Podria pasarle el grafo "idGlobalPlay" que quiero reproducir, q se yo.
                // El tema, es que cuando desea reproducir me lleva a una nueva activity que solo reproduce.
                // Pensar el tema de reproducir cualquier cosa que se me ocurra y en cualquier lugar de la App.
                startActivity(new Intent(getApplicationContext(), Play.class));
            }
        });

        btnReproducirNodos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * Construyo todos los nodos del grafo actual a reproducir
                 */
                c = new ConstructionGraph(getApplicationContext()); // Paso contexto actual
                String nodosString = c.ConstrucctionNodesString(idGlobalPlay); // obtengo todos los nodos del grafo pasado como parametro.
                g.setNodeCompletString(nodosString); // Guardo todos los nodos para reproducir en otra clase.

                Toast.makeText(OpcionesReproduccionGrafo.this, nodosString  , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Play.class));
            }
        });

        btnVolver_ReproduccionGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListPlay.class));
            }
        });

    }

}







