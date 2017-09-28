package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class CrearActivity extends AppCompatActivity {

    EditText etNombreGrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        etNombreGrafo = (EditText) findViewById(R.id.etNombreGrafo);

        Toast.makeText(getApplicationContext(), "Estoy en CREAR", Toast.LENGTH_SHORT).show();
        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());


    }
}
