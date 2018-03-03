package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by dario on 1/3/18.
 * Encargada de editar(Atributo, nodo Origen y nodo Destino) del enlace seleccionado.
 */

public class EditarEnlace extends AppCompatActivity {

    Button button_editar_nodo_origen_enlace, button_editar_nodo_destino_enlace,
    button_editar_guardar_enlace, button_editar_volver_atras_enlace;
    EditText et_editar_atributo_enlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_enlace);

        et_editar_atributo_enlace = findViewById(R.id.et_editar_atributo_enlace);
        button_editar_nodo_origen_enlace = findViewById(R.id.button_editar_nodo_origen_enlace);
        button_editar_nodo_destino_enlace = findViewById(R.id.button_editar_nodo_destino_enlace);
        button_editar_guardar_enlace = findViewById(R.id.button_editar_guardar_enlace);
        button_editar_volver_atras_enlace = findViewById(R.id.button_editar_volver_atras_enlace);

        /**
         * Cambiar valor de atributo
         */
        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        Globals g = Globals.getInstance();
        final int idEnlaceEdit = g.getIdEnlaceEdit(); // recupero el id del enlace a editar
        final int idGlobalEdit = g.getIdGlobalEdit(); // recupero el id del grafo a editar

        // pongo el atributo actual del enlace, en el campo a editar
        et_editar_atributo_enlace.setText(MDB.recoverEnlace(idEnlaceEdit).getAtributoEnlace());


        /**
         * Cambiar nodo Origen
         */
        button_editar_nodo_origen_enlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        /**
         * Cambiar nodo Destino
         */
        button_editar_nodo_destino_enlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        /**
         * Guardar cambios
         */
        button_editar_guardar_enlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        /**
         * Volver hacia atras
         */
        button_editar_volver_atras_enlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EnlaceListEdit.class);
                startActivity(intent);
            }
        });
    }


}
