package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CrearEnlaceActivity extends AppCompatActivity {

    Button btnNodoOrigen_CrearArco, btnNodoDestino_CrearArco, btnVolverAtras_CrearArco, btnCrearArco_CrearArco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_enlace);

        btnNodoOrigen_CrearArco = findViewById(R.id.btnNodoOrigen_CrearArco);
        btnNodoDestino_CrearArco = findViewById(R.id.btnNodoDestino_CrearArco);
        btnVolverAtras_CrearArco = findViewById(R.id.btnVolverAtras_CrearArco);
        btnCrearArco_CrearArco = findViewById(R.id.btnCrearArco_CrearArco);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        final Globals g = Globals.getInstance();

        btnNodoOrigen_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar una lista de nodos creados
                Intent intentNodeList = new Intent(CrearEnlaceActivity.this, NodeListOrigen.class);
                startActivity(intentNodeList);
            }
        });

        btnNodoDestino_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar una lista de nodos creados
                Intent intentNodeList = new Intent(CrearEnlaceActivity.this, NodeListDestino.class);
                startActivity(intentNodeList);
            }
        });


        btnCrearArco_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ( g.getIdOrigen() == 0 && g.getIdDestino() != 0){Toast.makeText(CrearEnlaceActivity.this, "NO AHI ORIGEN SELECCIONADO ))", Toast.LENGTH_SHORT).show();}
                if ( g.getIdOrigen() != 0 && g.getIdDestino() == 0){Toast.makeText(CrearEnlaceActivity.this, "NO AHI DESTINO SELECCIONADO ))", Toast.LENGTH_SHORT).show();}
                if ( g.getIdOrigen() == 0 && g.getIdDestino() == 0){ Toast.makeText(CrearEnlaceActivity.this, "NO AHI NI ORIGEN NI DESTINO SELECCIONADO", Toast.LENGTH_SHORT).show();}

                if ( g.getIdOrigen() != 0 && g.getIdDestino() != 0){
                    Toast.makeText(CrearEnlaceActivity.this, "ORIGEN: " + g.getIdOrigen() + " - DESTINO: " + g.getIdDestino(), Toast.LENGTH_SHORT).show();
                    int numeroEnlace = MDB.insertEnlace(g.getIdOrigen(), g.getIdDestino(), "atributo", g.getIdGlobal());
                    g.setIdOrigen(0);
                    g.setIdDestino(0);
                    Toast.makeText(CrearEnlaceActivity.this, "ENLACE CREADO NUMERO: "+ numeroEnlace, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnVolverAtras_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class));
            }
        });

    }

}


