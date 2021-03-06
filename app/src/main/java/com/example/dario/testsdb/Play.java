package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

/**
 * Clase dedicada a la reproduccion de frases.
 * Se instancian todos los metodos necesarios para la reproduccion de frases, que se pasaran como parametro.
 */

public class Play extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button btnReproducir_PLay, btnVolverAtras_PLay, btnRepetirReproduccion;
    Vibrator vibrator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        tts = new TextToSpeech(this, this);
        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        final Globals g = Globals.getInstance();

        btnReproducir_PLay = findViewById(R.id.btnReproducir_PLay);
        btnRepetirReproduccion = findViewById(R.id.btnRepetirReproduccion);
        btnVolverAtras_PLay = findViewById(R.id.btnVolverAtras_PLay);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        /**
         * Boton de reproduccion.
         */
        btnReproducir_PLay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Method yet to be defined
                if (g.getQuien() == "Nodo"){
                    speakOut(g.getNodeCompletString());
                }
                if (g.getQuien() == "Grafo"){
                    speakOut(g.getGrafoCompletString());
                }
            }
        });

        /**
         * Boton de repetir reproduccion.
         */
        btnRepetirReproduccion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Repito la reproduccion
                if (g.getQuien() == "Nodo"){
                    speakOut(g.getNodeCompletString());
                }
                if (g.getQuien() == "Grafo"){
                    speakOut(g.getGrafoCompletString());
                }
            }
        });

        /**
         * Boton para volver atras.
         */
        btnVolverAtras_PLay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OpcionesReproduccionGrafo.class));
                if (g.getVibrateActivado()){vibrator.vibrate(400);}
            }
        });

    }

    private void speakOut(String dataEntry) {
        // If no text is typed, tts will read out 'You haven't typed text'
        // else it reads out the text you typed
        if (dataEntry.length() == 0) {
            tts.speak("Sin nodos para reproducirgrafo", TextToSpeech.QUEUE_FLUSH, null);
        } else {
            tts.speak(dataEntry, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public void onDestroy() {
        // Don't forget to shutdown!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    public void onInit(int status) {
        // TODO Auto-generated method stub
        // TTS is successfully initialized
        if (status == TextToSpeech.SUCCESS) {
            // Setting speech language
            int result = tts.setLanguage(Locale.getDefault());
            // If your device doesn't support language you set above
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Cook simple toast message with message
                Toast.makeText(getApplicationContext(), "Language not supported",
                        Toast.LENGTH_LONG).show();
                Log.e("TTS", "Language is not supported");
            }
            // Enable the button - It was disabled in main.xml (Go back and
            // Check it)
            else {
                btnReproducir_PLay.setEnabled(true);
            }
            // TTS is not initialized properly
        } else {
            Toast.makeText(this, "TTS Initilization Failed", Toast.LENGTH_LONG)
                    .show();
            Log.e("TTS", "Initilization Failed");
        }
    }
}











