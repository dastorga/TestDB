package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        Globals g = Globals.getInstance();
        final int idEnlaceEdit = g.getIdEnlaceEdit(); // recupero el id del enlace a editar
        final int idGlobalEdit = g.getIdGlobalEdit(); // recupero el id del grafo a editar

        final int idOrigenEdit = g.getIdOrigenEdit(); // recupero el id del nodo origen a editar
        final int idDestinoEdit = g.getIdDestinoEdit(); // recupero el id del nodo destino a editar

        /**
         * Cambiar valor de atributo
         */
        // pongo el atributo actual del enlace, en el campo a editar
        et_editar_atributo_enlace.setText(MDB.recoverEnlace(idEnlaceEdit).getAtributoEnlace());


        /**
         * Cambiar nodo Origen
         */
        button_editar_nodo_origen_enlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar la lista de todos los nodos creados
                // luego de mostrar la lista de nodos, actualizar la variable global del nodo seleccionado.
                Intent intentListNodos = new Intent(EditarEnlace.this, ListNodosUpdateOrigen.class);
                startActivity(intentListNodos);
            }
        });

        /**
         * Cambiar nodo Destino
         */
        button_editar_nodo_destino_enlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar la lista de todos los nodos creados
                // luego de mostrar la lista de nodos, actualizar la variable global del nodo seleccionado.

                Intent intentListNodos = new Intent(EditarEnlace.this, ListNodosUpdateDestino.class);
                startActivity(intentListNodos);
            }
        });

        /**
         * Guardar cambios
         */
        button_editar_guardar_enlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Lo ultimo que termino haciendo es actualizar el enlace con lo que se alla modificado o no.
                //MDB.updateEnlace(idEnlaceEdit, et_editar_atributo_enlace.getText().toString(), idOrigenEdit, idDestinoEdit, idGlobalEdit);
                Toast.makeText(EditarEnlace.this, "EDITADO ))", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), EnlaceListEdit.class));
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
