package com.example.dario.testsdb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Clase encargada de ejecutar el Splash Screen
 */

public class SplashScreen extends AppCompatActivity {

    private TextView tvSplashScreen;
    private ImageView im;
    MediaPlayer inicio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        im = (ImageView) findViewById(R.id.imageViewSplashScreen);
        tvSplashScreen = (TextView) findViewById(R.id.tvSplashScreen);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);

        inicio = MediaPlayer.create(this, R.raw.inicio);
        final Intent i = new Intent(this, MainActivity.class);

        im.startAnimation(myanim);
        tvSplashScreen.startAnimation(myanim);
        inicio.start();


        Thread timer = new Thread(){
            public void run (){
                try{
                    sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                    inicio.stop();
                }
            }
        };

        timer.start();
    }
}
