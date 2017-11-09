package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CrearEnlaceActivity extends AppCompatActivity {

    Button btnPrimerNodo_CrearArco, btnSegundoNodo_CrearArco, btnVolverAtras_CrearArco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_enlace);

        btnPrimerNodo_CrearArco = (Button) findViewById(R.id.btnPrimerNodo_CrearArco);
        btnSegundoNodo_CrearArco = (Button) findViewById(R.id.btnSegundoNodo_CrearArco);
        btnVolverAtras_CrearArco = (Button) findViewById(R.id.btnVolverAtras_CrearArco);
        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        btnPrimerNodo_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            //aca debo mostrar una lista de nodos creados

                //Me retorna una lista de todos los nodos del grafo que paso como parametro.
//                MDB.recoverNodesInGraph()

            }
        });

        btnSegundoNodo_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        btnVolverAtras_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class));
            }
        });

    }
}
