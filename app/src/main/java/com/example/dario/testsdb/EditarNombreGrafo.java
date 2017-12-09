package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * EDITA EL NOMBRE DEL GRAFO
 */


public class EditarNombreGrafo extends AppCompatActivity {

    Button btnGuardarEdicion_EditarNombreGrafo, btnVolverAtras_EditarNombreGrafo;
    EditText etEditarNombreGrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_nombre_grafo);

        btnGuardarEdicion_EditarNombreGrafo = (Button) findViewById(R.id.btnGuardarEdicion_EditarNombreGrafo);
        btnVolverAtras_EditarNombreGrafo = (Button) findViewById(R.id.btnVolverAtras_EditarNombreGrafo);
        etEditarNombreGrafo = (EditText) findViewById(R.id.etEditarNombreGrafo);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        Globals g = Globals.getInstance();
        final int idGlobalEdit = g.getIdGlobalEdit();

        etEditarNombreGrafo.setText(MDB.recoverGraph(idGlobalEdit).getNameGraph());

        btnGuardarEdicion_EditarNombreGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MDB.updateGraph(idGlobalEdit, etEditarNombreGrafo.getText().toString());
                Toast.makeText(EditarNombreGrafo.this, "EDITADO ))", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), EditarGrafo.class));
            }
        });

        btnVolverAtras_EditarNombreGrafo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EditarGrafo.class));
            }
        });

    }
}
