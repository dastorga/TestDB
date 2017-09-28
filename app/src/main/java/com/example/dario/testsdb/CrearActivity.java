package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CrearActivity extends AppCompatActivity {

    EditText etNombreGrafo;
    Button btnGuardar,btnEditar,btnVolverAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        etNombreGrafo = (EditText) findViewById(R.id.etNombreGrafo);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnVolverAtras = (Button) findViewById(R.id.btnVolverAtras);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

//                String nombreGrafo = etNombreGrafo.getText().toString();
//                MDB.insertGraph(1,nombreGrafo);
//
//                Toast.makeText(getApplicationContext(), "GUARDADO", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
//                Toast.makeText(getApplicationContext(), MDB.recoverGraph(1).getNameGraph(), Toast.LENGTH_SHORT).show();

            }
        });

        btnVolverAtras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
//                Toast.makeText(getApplicationContext(), "ATRAS", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });


    }
}
