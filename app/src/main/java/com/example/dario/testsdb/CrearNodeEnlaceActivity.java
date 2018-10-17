package com.example.dario.testsdb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * AÑADIR COMENTARIO
 */

public class CrearNodeEnlaceActivity extends AppCompatActivity {

    Button btnCrearNode, btnCrearEnlace, btnVolverAtrasCrearNodeEnlaceActivity;
    MediaPlayer volver,noahinodoscreados;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_node_enlace);

        btnCrearNode = findViewById(R.id.btnCrearNode);
        btnCrearEnlace = findViewById(R.id.btnCrearEnlace);
        btnVolverAtrasCrearNodeEnlaceActivity = findViewById(R.id.btnVolverAtrasCrearNodeEnlaceActivity);
        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        volver = MediaPlayer.create(this, R.raw.volver);
        noahinodoscreados = MediaPlayer.create(this, R.raw.noahinodoscreados);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        btnCrearNode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearNodeActivity.class));
            }
        });

        btnCrearEnlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Globals g = Globals.getInstance();
                int idGlobal = g.getIdGlobal();
                if (MDB.existsNodesInGraph(idGlobal)){
                    startActivity(new Intent(getApplicationContext(), CrearEnlaceActivity.class));
                }else{
                    //pattern conformado por silencio seguido de duracion
                    long [] pattern = {0,350,100,350};
                    if (g.getVibrateActivado()){vibrator.vibrate(pattern,-1);}
                    Toast.makeText(getApplicationContext(),"NO ahi Nodos creados!", Toast.LENGTH_SHORT).show();
                    if (g.getSonidoActivado()){noahinodoscreados.start();}
                }

            }
        });

        btnVolverAtrasCrearNodeEnlaceActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Globals g = Globals.getInstance();
                startActivity(new Intent(getApplicationContext(), CrearGrafo.class));
                if (g.getVibrateActivado()){vibrator.vibrate(400);}
                if (g.getSonidoActivado()){volver.start();}
            }
        });

    }
}
