package com.example.dario.testsdb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Creacion del grafo actual.
 */

public class CrearGrafo extends AppCompatActivity {

    EditText etNombreGrafo;
    Button btnGuardarNombreGrafo,btnVolverAtrasGrafo;
    MediaPlayer clicksuccess, volver, volveratras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_grafo);

        etNombreGrafo = findViewById(R.id.etNombreGrafo);
        btnGuardarNombreGrafo = findViewById(R.id.btnGuardarNombreGrafo);
        btnVolverAtrasGrafo = findViewById(R.id.btnVolverAtrasGrafo);

        clicksuccess = MediaPlayer.create(this, R.raw.clicksuccess);
        volver = MediaPlayer.create(this, R.raw.volver);
        volveratras = MediaPlayer.create(this, R.raw.volveratras);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        btnGuardarNombreGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String nombreGrafo = etNombreGrafo.getText().toString();
                int id = MDB.insertGraph(nombreGrafo);

                Globals g = Globals.getInstance();
                g.setIdGlobal(id); //guardo el Id de este ultimo grafo actual

                Toast.makeText(getApplicationContext(),MDB.recoverGraph(g.getIdGlobal()).getNameGraph()+" Guardado!" + " IdGraph: " +  g.getIdGlobal(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class));
                if (g.getSonidoActivado()){clicksuccess.start();}
            }
        });

        btnVolverAtrasGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Globals g = Globals.getInstance();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                if (g.getSonidoActivado()){volver.start();}
                if (g.getSonidoActivado()){volveratras.start();}
            }
        });
    }
}
