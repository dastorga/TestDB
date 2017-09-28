package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CrearNodeEnlaceActivity extends AppCompatActivity {

    Button btnCrearNode, btnCrearEnlace, btnVolverAtrasCrearNodeEnlaceActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_node_enlace);

        btnCrearNode = (Button) findViewById(R.id.btnCrearNode);
        btnCrearEnlace = (Button) findViewById(R.id.btnCrearEnlace);
        btnVolverAtrasCrearNodeEnlaceActivity = (Button) findViewById(R.id.btnVolverAtrasCrearNodeEnlaceActivity);

        btnCrearNode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        btnCrearEnlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        btnVolverAtrasCrearNodeEnlaceActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearActivity.class));

            }
        });

    }
}
