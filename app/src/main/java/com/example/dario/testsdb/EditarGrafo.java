package com.example.dario.testsdb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Opciones para editar: nombre de grafo, nodos, arcos
 */

public class EditarGrafo extends AppCompatActivity {

    Button btnEditarNombreGrafo, btnEditarNodosGrafo, btnEditarEnlacesGrafo, btnVolverAtrasEditarGrafo,
    btnAgregarNodoGrafo, btnAgregarEnlaceGrafo;
    MediaPlayer volver, volveratras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_grafo);

        btnEditarNombreGrafo = findViewById(R.id.btnEditarNombreGrafo);
        btnEditarNodosGrafo = findViewById(R.id.btnEditarNodosGrafo);
        btnEditarEnlacesGrafo = findViewById(R.id.btnEditarEnlacesGrafo);
        btnVolverAtrasEditarGrafo = findViewById(R.id.btnVolverAtrasEditarGrafo);

        btnAgregarNodoGrafo = findViewById(R.id.btnAgregarNodoGrafo);
        btnAgregarEnlaceGrafo = findViewById(R.id.btnAgregarEnlaceGrafo);

        volver = MediaPlayer.create(this, R.raw.volver);
        volveratras = MediaPlayer.create(this, R.raw.volveratras);

        final Globals g = Globals.getInstance();

        btnEditarNombreGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EditarNombreGrafo.class));
            }
        });

        btnEditarNodosGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(getApplicationContext(), NodoListEdit.class));
            }
        });

        btnEditarEnlacesGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(getApplicationContext(), EnlaceListEdit.class));
            }
        });

        btnAgregarNodoGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), AgregarNodoGrafo.class));
            }
        });

        btnAgregarEnlaceGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), AgregarEnlaceGrafo.class));
            }
        });

        btnVolverAtrasEditarGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GraphListEdit.class);
                startActivity(intent);
                if (g.getSonidoActivado()){volver.start();}
                if (g.getSonidoActivado()){volveratras.start();}
            }
        });

    }
}
