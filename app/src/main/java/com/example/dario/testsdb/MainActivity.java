package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnCrear = (Button) findViewById(R.id.btnCrear);
        final Button btnEliminar = (Button) findViewById(R.id.btnEliminar);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());


        btnCrear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Toast.makeText(getApplicationContext(), "Opcion Crear", Toast.LENGTH_SHORT).show();


            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Toast.makeText(getApplicationContext(), "Opcion Eliminar", Toast.LENGTH_SHORT).show();

            }
        });



    }
}
