package com.example.dario.testsdb;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

import java.util.Locale;

/**
 * Clase dedicada a la reproduccion de frases.
 * Se instancian todos los metodos necesarios para la reproduccion de frases, que se pasaran como parametro.
 */

public class Play extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button speak;
    private EditText getTextToSpeak;

    @Override
    protected void onCreate(BundlesavedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, this);
        getTextToSpeak = (EditText) findViewById(R.id.editTextT);
        speak = (Button) findViewById(R.id.speakOut);

        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(Viewview) {
                speakOutNow();
            }
        });
    }

    @Override
    public void onInit(inttext) {
        if (text ==TextToSpeech.SUCCESS) {
            int language = tts.setLanguage(Locale.ENGLISH); //YOU CAN CHANGE YOUR LANGUAGE
            if (language ==TextToSpeech.LANG_MISSING_DATA || language ==TextToSpeech.LANG_NOT_SUPPORTED){
                speak.setEnabled(true);
                speakOutNow(); //YOU CAN TRY REMOVE THIS LINE
            }
            else {
                //put a toast
            }
        }
        else{
        }
    }

    private void speakOutNow (){
        String text = getTextToSpeak.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }


}
