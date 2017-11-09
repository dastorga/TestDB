package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCrear,btnEliminar,btnEditar,btnReproducir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = (Button) findViewById(R.id.btnCrear);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnReproducir = (Button) findViewById(R.id.btnReproducir);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        MDB.dropTable("GRAPH");
        MDB.dropTable("NODE");
        MDB.dropTable("ENLACE");

        btnCrear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearActivity.class));
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


    }
}
