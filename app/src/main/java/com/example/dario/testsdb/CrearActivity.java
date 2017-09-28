package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearActivity extends AppCompatActivity {

    EditText etNombreGrafo;
    Button btnGuardarNombreGrafo,btnBorrarNombreGrafo,btnVolverAtrasGrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        etNombreGrafo = (EditText) findViewById(R.id.etNombreGrafo);
        btnGuardarNombreGrafo = (Button) findViewById(R.id.btnGuardarNombreGrafo);
        btnBorrarNombreGrafo = (Button) findViewById(R.id.btnBorrarNombreGrafo);
        btnVolverAtrasGrafo = (Button) findViewById(R.id.btnVolverAtrasGrafo);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        btnGuardarNombreGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                String nombreGrafo = etNombreGrafo.getText().toString();
                MDB.insertGraph(1,nombreGrafo);

                Toast.makeText(getApplicationContext(), "GUARDADO", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

        btnBorrarNombreGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Toast.makeText(getApplicationContext(), MDB.recoverGraph(1).getNameGraph(), Toast.LENGTH_SHORT).show();

            }
        });

        btnVolverAtrasGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Toast.makeText(getApplicationContext(), "ATRAS", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });


    }
}
