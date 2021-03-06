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
 * Activity de confirmacion antes de eliminargrafo grafo.
 */

public class WarningNotice extends AppCompatActivity {

    Button btnAceptarWarningNotice, btnCancelarWarningNotice;
    MediaPlayer click, grafoeliminado, grafonoeliminado;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warning_notice);

        btnAceptarWarningNotice = findViewById(R.id.btnAceptarWarningNotice);
        btnCancelarWarningNotice = findViewById(R.id.btnCancelarWarningNotice);
        final Globals g = Globals.getInstance();
        click = MediaPlayer.create(this, R.raw.clicksuccess);
        grafoeliminado = MediaPlayer.create(this, R.raw.grafoeliminado);
        grafonoeliminado = MediaPlayer.create(this, R.raw.grafonoeliminado);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        btnAceptarWarningNotice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dato = getIntent().getExtras().getString("id_graph");
                MDB.deleteGraph(Integer.parseInt(dato));
                Toast.makeText(WarningNotice.this, "GRAFO "+Integer.parseInt(dato)+" ELIMINADO", Toast.LENGTH_SHORT).show();
                Intent intentCrearEnlace = new Intent(getApplicationContext(), GraphListDelete.class);
                startActivity(intentCrearEnlace);
                if (g.getVibrateActivado()){vibrator.vibrate(800);}
                if (g.getSonidoActivado()){click.start();}
                if (g.getSonidoActivado()){grafoeliminado.start();}
            }
        });

        btnCancelarWarningNotice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentCrearEnlace = new Intent(getApplicationContext(), GraphListDelete.class);
                startActivity(intentCrearEnlace);
                if (g.getSonidoActivado()){grafonoeliminado.start();}
            }
        });

    }
}
