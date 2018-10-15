package com.example.dario.testsdb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Edita el nombre del grafo seleccionado.
 */


public class EditarNombreGrafo extends AppCompatActivity {

    Button btnGuardarEdicion_EditarNombreGrafo, btnVolverAtras_EditarNombreGrafo;
    EditText etEditarNombreGrafo;
    MediaPlayer clicksuccess, volver, volveratras;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_nombre_grafo);

        btnGuardarEdicion_EditarNombreGrafo = findViewById(R.id.btnGuardarEdicion_EditarNombreGrafo);
        btnVolverAtras_EditarNombreGrafo = findViewById(R.id.btnVolverAtras_EditarNombreGrafo);
        etEditarNombreGrafo = findViewById(R.id.etEditarNombreGrafo);
        clicksuccess = MediaPlayer.create(this, R.raw.clicksuccess);
        volver = MediaPlayer.create(this, R.raw.volver);
        volveratras = MediaPlayer.create(this, R.raw.volveratras);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        final Globals g = Globals.getInstance();
        final int idGlobalEdit = g.getIdGlobalEdit();

        etEditarNombreGrafo.setText(MDB.recoverGraph(idGlobalEdit).getNameGraph());

        btnGuardarEdicion_EditarNombreGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MDB.updateGraph(idGlobalEdit, etEditarNombreGrafo.getText().toString());
                Toast.makeText(EditarNombreGrafo.this, "EDITADO ))", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), EditarGrafo.class));
                if (g.getVibrateActivado()){vibrator.vibrate(800);}
                if (g.getSonidoActivado()){clicksuccess.start();}
            }
        });

        btnVolverAtras_EditarNombreGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EditarGrafo.class));
                if (g.getVibrateActivado()){vibrator.vibrate(400);}
                if (g.getSonidoActivado()){volver.start();}
                if (g.getSonidoActivado()){volveratras.start();}
            }
        });

    }
}
