package com.example.dario.testsdb;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

/**
 * Clase encargada de presentar opciones para una basica configuracion de la aplicacion.
 * Aqui se selecciona si deseo que la aplicacion tengo sonidos o no los tenga, osea sea accesible
 * por si sola o no lo sea y se use TalkBack del sistema operativo.
 */

public class ConfigurationGraph extends AppCompatActivity {
    Switch switchSonido;
    MediaPlayer sonidoactivado, sonidodesactivado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        sonidoactivado = MediaPlayer.create(this, R.raw.sonidoactivado);
        sonidodesactivado = MediaPlayer.create(this, R.raw.sonidodesactivado);
        switchSonido = findViewById(R.id.switchSonido);
        final Globals g = Globals.getInstance();

        if(g.getSonidoActivado()) {
            switchSonido.setChecked(true);
            switchSonido.setText("Sonido: ON");
        }
        else {
            switchSonido.setChecked(false);
            switchSonido.setText("Sonido: OFF");
        }

        /**
         * Funcion que me activa los sonidos al creargrafo un grafo y
         * al hacer click sobre el boton volver.
         * Se utiliza una funcion global "setSonidoActivado"
         */
        switchSonido.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                if(switchSonido.isChecked()) {
                    g.setSonidoActivado(true);
                    switchSonido.setText("Sonido: ON");
                    sonidoactivado.start();
                }
                else {
                    g.setSonidoActivado(false);
                    switchSonido.setText("Sonido: OFF");
                    sonidodesactivado.start();
                }
            }
        });







    }

}
