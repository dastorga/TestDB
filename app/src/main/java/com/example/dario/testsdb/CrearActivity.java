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
    Button btnGuardarNombreGrafo,btnVolverAtrasGrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        etNombreGrafo = (EditText) findViewById(R.id.etNombreGrafo);
        btnGuardarNombreGrafo = (Button) findViewById(R.id.btnGuardarNombreGrafo);
        btnVolverAtrasGrafo = (Button) findViewById(R.id.btnVolverAtrasGrafo);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        btnGuardarNombreGrafo.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                String nombreGrafo = etNombreGrafo.getText().toString();

                int id = MDB.insertGraph(nombreGrafo);

                // set
                ClassGlobal global = new ClassGlobal(id);
                global.setIdGlobal(id);

                Toast.makeText(getApplicationContext(), "Id creado numero: "+ global.getIdGlobal(), Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class));


            }
        });

        btnVolverAtrasGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ClassGlobal global = new ClassGlobal();
                int idglobal = global.getIdGlobal();

                Toast.makeText(getApplicationContext(), "Id creado numero: "+ idglobal, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


    }
}
