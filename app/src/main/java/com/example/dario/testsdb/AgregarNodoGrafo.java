package com.example.dario.testsdb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by dario on 6/6/18.
 * Clase encargada de agregar un nodo al grafo que se eligio editar.
 */

public class AgregarNodoGrafo extends AppCompatActivity {

    Button btnGuardar_CrearNode,btnVolverAtras_CrearNode;
    EditText etNombreNode_CrearNode;
    MediaPlayer clicksuccess, volver, volveratras, nodoagregado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_node);

        btnGuardar_CrearNode = findViewById(R.id.btnGuardar_CrearNode);
        btnVolverAtras_CrearNode = findViewById(R.id.btnVolverAtras_CrearNode);
        etNombreNode_CrearNode = findViewById(R.id.etNombreNode_CrearNode);
        clicksuccess = MediaPlayer.create(this, R.raw.clicksuccess);
        volver = MediaPlayer.create(this, R.raw.volver);
        volveratras = MediaPlayer.create(this, R.raw.volveratras);
        nodoagregado = MediaPlayer.create(this, R.raw.nodoagregado);

        btnGuardar_CrearNode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

                final Globals g = Globals.getInstance();
                final int idGlobalEdit = g.getIdGlobalEdit();

                String atributo = etNombreNode_CrearNode.getText().toString();
                int newRowId = MDB.insertNode(atributo, idGlobalEdit);

                Toast.makeText(getApplicationContext(),"newRowId: "+ newRowId + "IdGraph: " + idGlobalEdit , Toast.LENGTH_SHORT).show();

                Intent intentCrearEnlace = new Intent(getApplicationContext(), EditarGrafo.class);
                startActivity(intentCrearEnlace);
                if (g.getSonidoActivado()){
                    clicksuccess.start();
                    nodoagregado.start();
                }
            }
        });

        btnVolverAtras_CrearNode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Globals g = Globals.getInstance();
                startActivity(new Intent(getApplicationContext(), EditarGrafo.class));
                if (g.getSonidoActivado()){volver.start();}
                if (g.getSonidoActivado()){volveratras.start();}
            }
        });

    }


}
