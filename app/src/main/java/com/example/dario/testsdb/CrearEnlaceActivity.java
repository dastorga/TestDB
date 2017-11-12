package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CrearEnlaceActivity extends AppCompatActivity {

    Button btnNodoOrigen_CrearArco, btnNodoDestino_CrearArco, btnVolverAtras_CrearArco;
    int id_Origen, id_Destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_enlace);

        btnNodoOrigen_CrearArco = (Button) findViewById(R.id.btnNodoOrigen_CrearArco);
        btnNodoDestino_CrearArco = (Button) findViewById(R.id.btnNodoDestino_CrearArco);
        btnVolverAtras_CrearArco = (Button) findViewById(R.id.btnVolverAtras_CrearArco);

        id_Origen = 0; // las inicializo en cero
        id_Destino = 0; // las inicializo en cero


        MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        final Globals g = Globals.getInstance();
        int id_Graph = g.getIdGlobal();


        btnNodoOrigen_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Aqui debo mostrar una lista de nodos creados y dar la posibilidad de seleccionar uno
                Intent intentNodeList = new Intent(CrearEnlaceActivity.this, NodeListOrigen.class);
                startActivity(intentNodeList);
                id_Origen = g.getIdOrigen();

            }
        });

        btnNodoDestino_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Aqui debo mostrar una lista de nodos creados y dar la posibilidad de seleccionar uno
                Intent intentNodeList = new Intent(CrearEnlaceActivity.this, NodeListDestino.class);
                startActivity(intentNodeList);
                id_Destino = g.getIdDestino();

            }
        });



        if (id_Origen != 0 && id_Destino != 0){
            //inserto el enlace
            Toast.makeText(CrearEnlaceActivity.this, "ORIGEN: " + id_Origen + " - DESTINO: " + id_Destino, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(CrearEnlaceActivity.this, "NO AHI DESTINO / NO AHI ORIGEN", Toast.LENGTH_SHORT).show();
        }



        btnVolverAtras_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class));
            }
        });

    }

}
