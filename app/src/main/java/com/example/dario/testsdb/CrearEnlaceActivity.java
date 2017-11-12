package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CrearEnlaceActivity extends AppCompatActivity {

    Button btnNodoOrigen_CrearArco, btnNodoDestino_CrearArco, btnVolverAtras_CrearArco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_enlace);

        btnNodoOrigen_CrearArco = (Button) findViewById(R.id.btnNodoOrigen_CrearArco);
        btnNodoDestino_CrearArco = (Button) findViewById(R.id.btnNodoDestino_CrearArco);
        btnVolverAtras_CrearArco = (Button) findViewById(R.id.btnVolverAtras_CrearArco);

        btnNodoOrigen_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar una lista de nodos creados y dar la posibilidad de seleccionar uno
                Intent intentNodeList = new Intent(CrearEnlaceActivity.this, NodeListOrigen.class);
                startActivity(intentNodeList);
            }
        });

        btnNodoDestino_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar una lista de nodos creados y dar la posibilidad de seleccionar uno
                Intent intentNodeList = new Intent(CrearEnlaceActivity.this, NodeListOrigen.class);
                startActivity(intentNodeList);
            }
        });

        final Globals g = Globals.getInstance();
        int id_Origen = g.getIdOrigen();

        btnVolverAtras_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class));
            }
        });

    }
}
