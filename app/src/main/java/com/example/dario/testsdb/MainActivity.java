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
    MediaPlayer click, editar, eliminar, exportar, configuracion, reproducir, crear;

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

        editar = MediaPlayer.create(this, R.raw.editar);
        eliminar = MediaPlayer.create(this, R.raw.eliminar);
        exportar = MediaPlayer.create(this, R.raw.exportar);
        configuracion = MediaPlayer.create(this, R.raw.configuracion);
        reproducir = MediaPlayer.create(this, R.raw.reproducir);
        crear = MediaPlayer.create(this, R.raw.crear);

        /**
         * Audios desactivados por defecto.
         */
        final Globals g = Globals.getInstance();
        g.setSonidoActivado(false);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearGrafo.class));
                if (g.getSonidoActivado()){crear.start();}
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListEdit.class));
                if (g.getSonidoActivado()){editar.start();}
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListDelete.class));
                if (g.getSonidoActivado()){eliminar.start();}
            }
        });

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListPlay.class));
                if (g.getSonidoActivado()){reproducir.start();}
            }
        });

        btnExportar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListExport.class));
                if (g.getSonidoActivado()){exportar.start();}
            }
        });

        btnConfiguracion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * Funcion que me activa los sonidos al crear un grafo y
                 * al hacer click sobre el boton volver.
                 * Se utiliza una funcion global "setSonidoActivado"
                 */
                //startActivity(new Intent(getApplicationContext(), GraphListExport.class));
                g.setSonidoActivado(true);
                if (g.getSonidoActivado()){configuracion.start();}
            }
        });

    }
}
