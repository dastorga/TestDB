package com.example.dario.testsdb;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

/**
 * Clase dedicada a la reproduccion de frases.
 * Se instancian todos los metodos necesarios para la reproduccion de frases, que se pasaran como parametro.
 */

public class Play extends AppCompatActivity {

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcines_reproduccion_grafo);

         textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                    textToSpeech.setLanguage(Locale.getDefault());
            }
        });

        String string = "Hola";
        textToSpeech.speak(string,TextToSpeech.QUEUE_FLUSH,null,null);
    }


}











