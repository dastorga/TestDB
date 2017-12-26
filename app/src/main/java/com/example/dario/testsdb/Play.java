package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
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
    private Button btnReproducir_PLay,btnVolverAtras_PLay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        tts = new TextToSpeech(this, this);
        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        btnReproducir_PLay = (Button) findViewById(R.id.btnReproducir_PLay);
        btnVolverAtras_PLay = (Button) findViewById(R.id.btnVolverAtras_PLay);

        btnReproducir_PLay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Method yet to be defined
                speakOut();
            }
        });

        btnVolverAtras_PLay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OpcionesReproduccionGrafo.class));
            }
        });

    }

    private void speakOut() {
        // Get the text typed
        String text = "Probando, probando!!";
        // If no text is typed, tts will read out 'You haven't typed text'
        // else it reads out the text you typed
        if (text.length() == 0) {
            tts.speak("You haven't typed text", TextToSpeech.QUEUE_FLUSH, null);
        } else {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

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











