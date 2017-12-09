package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EditarGrafo extends AppCompatActivity {

    Button btnEditarNombreGrafo, btnEditarNodosGrafo, btnEditarEnlacesGrafo, btnVolverAtrasEditarGrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_grafo);

        btnEditarNombreGrafo = (Button) findViewById(R.id.btnEditarNombreGrafo);
        btnEditarNodosGrafo = (Button) findViewById(R.id.btnEditarNodosGrafo);
        btnEditarEnlacesGrafo = (Button) findViewById(R.id.btnEditarEnlacesGrafo);
        btnVolverAtrasEditarGrafo = (Button) findViewById(R.id.btnVolverAtrasEditarGrafo);

        btnEditarNombreGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EditarNombreGrafo.class));
            }
        });

        btnEditarNodosGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(getApplicationContext(), NodoListEdit.class));
            }
        });

        btnEditarEnlacesGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // startActivity(new Intent(getApplicationContext(), .class));
            }
        });

        btnVolverAtrasEditarGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GraphListEdit.class);
                startActivity(intent);
            }
        });

    }
}
