package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearActivity extends AppCompatActivity {

    EditText etNombreGrafo;
    Button btnGuardar,btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        etNombreGrafo = (EditText) findViewById(R.id.etNombreGrafo);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        Toast.makeText(getApplicationContext(), "Estoy en CREAR", Toast.LENGTH_SHORT).show();



    }
}
