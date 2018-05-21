package com.example.dario.testsdb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 *
 * MAIN DE LA APLICACION
 */

public class MainActivity extends AppCompatActivity {

    Button btnCrear, btnEliminar, btnEditar, btnReproducir, btnExportar;
    MediaPlayer click, mario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnEditar = findViewById(R.id.btnEditar);
        btnReproducir = findViewById(R.id.btnReproducir);
        btnExportar = findViewById(R.id.btnExportar);

        click = MediaPlayer.create(this, R.raw.click);
        mario = MediaPlayer.create(this, R.raw.mario);


        /**
         * Funcion que me activa los sonidos al crear un grafo y
         * al hacer click sobre el boton volver.
         */
        final Globals g = Globals.getInstance();
        g.setSonidoActivado(true);
        mario.start();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearGrafo.class));
                mario.stop();
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListEdit.class));
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListDelete.class));
            }
        });

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListPlay.class));
            }
        });

        btnExportar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListExport.class));
            }
        });

    }
}
