package com.example.dario.testsdb;

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

    private TextView tv;
    private ImageView im;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        im = (ImageView) findViewById(R.id.imageViewSplashScreen);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        im.startAnimation(myanim);


    }
}
