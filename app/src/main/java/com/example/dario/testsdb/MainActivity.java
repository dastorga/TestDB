package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 *
 * MAIN DE LA PLAICACION
 */

public class MainActivity extends AppCompatActivity {

    Button btnCrear, btnEliminar, btnEditar, btnReproducir, btnExportar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = (Button) findViewById(R.id.btnCrear);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnReproducir = (Button) findViewById(R.id.btnReproducir);
        btnExportar = (Button) findViewById(R.id.btnExportar);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearGrafo.class));
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListEdit.class));
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListDelete.class));
            }
        });

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListPlay.class));
            }
        });

        btnExportar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphListExport.class));
            }
        });

    }
}
