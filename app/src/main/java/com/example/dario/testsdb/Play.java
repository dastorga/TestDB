package com.example.dario.testsdb;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

/**
 * Clase dedicada a la reproduccion de frases.
 * Se instancian todos los metodos necesarios para la reproduccion de frases, que se pasaran como parametro.
 */

public class Play extends AppCompatActivity {

    TextToSpeech tt;
    Button b1;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tt=new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                if(status!=TextToSpeech.ERROR)
                    tt.setLanguage(Locale.getDefault());
            }
        });

        b1=(Button)findViewById(R.id.button);
        ed=(EditText)findViewById(R.id.editText);
    }

    public void speak_my_text(View vv)
    {
        String string =ed.getText().toString();
        tt.speak(string,TextToSpeech.QUEUE_FLUSH,null,null);
    }

}











