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
 * AÑADIR COMENTARIO DE LA CLASE
 */

public class CrearNodeActivity extends AppCompatActivity {

    Button btnGuardar_CrearNode,btnVolverAtras_CrearNode;
    EditText etNombreNode_CrearNode;
    MediaPlayer clicksuccess, volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_node);

        btnGuardar_CrearNode = findViewById(R.id.btnGuardar_CrearNode);
        btnVolverAtras_CrearNode = findViewById(R.id.btnVolverAtras_CrearNode);
        etNombreNode_CrearNode = findViewById(R.id.etNombreNode_CrearNode);
        clicksuccess = MediaPlayer.create(this, R.raw.clicksuccess);
        volver = MediaPlayer.create(this, R.raw.volver);

        btnGuardar_CrearNode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

                Globals g = Globals.getInstance();
                int idGlobalGraph = g.getIdGlobal(); //get el id_global actual del graph

                String atributo = etNombreNode_CrearNode.getText().toString();
                int newRowId = MDB.insertNode(atributo, idGlobalGraph);

                Toast.makeText(getApplicationContext(),"newRowId: "+ newRowId + "IdGraph: " + idGlobalGraph , Toast.LENGTH_SHORT).show();

                Intent intentCrearEnlace = new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class);
                startActivity(intentCrearEnlace);
                if (g.getSonidoActivado()){clicksuccess.start();}
            }
        });

        btnVolverAtras_CrearNode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Globals g = Globals.getInstance();
                startActivity(new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class));
                if (g.getSonidoActivado()){volver.start();}
            }
        });

    }
}
