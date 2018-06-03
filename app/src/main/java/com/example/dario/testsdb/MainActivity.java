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

    Button btnCrear, btnEliminar, btnEditar, btnReproducir, btnExportar, btnConfiguracion;
    MediaPlayer click, editargrafo, eliminargrafo, exportargrafo, configurargrafo, reproducirgrafo, creargrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnEditar = findViewById(R.id.btnEditar);
        btnReproducir = findViewById(R.id.btnReproducir);
        btnExportar = findViewById(R.id.btnExportar);
        btnConfiguracion = findViewById(R.id.btnConfiguracion);
        click = MediaPlayer.create(this, R.raw.click);

        editargrafo = MediaPlayer.create(this, R.raw.editargrafo);
        eliminargrafo = MediaPlayer.create(this, R.raw.eliminargrafo);
        exportargrafo = MediaPlayer.create(this, R.raw.exportargrafo);
        configurargrafo = MediaPlayer.create(this, R.raw.configurargrafo);
        reproducirgrafo = MediaPlayer.create(this, R.raw.reproducirgrafo);
        creargrafo = MediaPlayer.create(this, R.raw.creargrafo);

        /**
         * Audios desactivados por defecto.
         */
        final Globals g = Globals.getInstance();
        g.setSonidoActivado(false);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearGrafo.class));
                if (g.getSonidoActivado()){creargrafo.start();}
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListEdit.class));
                if (g.getSonidoActivado()){editargrafo.start();}
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListDelete.class));
                if (g.getSonidoActivado()){eliminargrafo.start();}
            }
        });

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListPlay.class));
                if (g.getSonidoActivado()){reproducirgrafo.start();}
            }
        });

        btnExportar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListExport.class));
                if (g.getSonidoActivado()){exportargrafo.start();}
            }
        });

        btnConfiguracion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * Funcion que me activa los sonidos al creargrafo un grafo y
                 * al hacer click sobre el boton volver.
                 * Se utiliza una funcion global "setSonidoActivado"
                 */
                //startActivity(new Intent(getApplicationContext(), GraphListExport.class));
                g.setSonidoActivado(true);
                if (g.getSonidoActivado()){configurargrafo.start();}
            }
        });

    }
}
