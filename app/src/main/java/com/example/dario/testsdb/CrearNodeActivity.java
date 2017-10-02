package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearNodeActivity extends AppCompatActivity {

    Button btnGuardar_CrearNode,btnVolverAtras_CrearNode;
    EditText etNombreNode_CrearNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_node);

        btnGuardar_CrearNode = (Button) findViewById(R.id.btnGuardar_CrearNode);
        btnVolverAtras_CrearNode = (Button) findViewById(R.id.btnVolverAtras_CrearNode);
        etNombreNode_CrearNode = (EditText) findViewById(R.id.etNombreNode_CrearNode);

        btnGuardar_CrearNode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

                Globals g = Globals.getInstance();
                int idGlobalGraph = g.getIdGlobal();

                String atributo = etNombreNode_CrearNode.getText().toString();
                int newRowId = MDB.insertNode(atributo, idGlobalGraph);

                Toast.makeText(getApplicationContext(),"newRowId: "+ newRowId + "IdGraph: " + idGlobalGraph , Toast.LENGTH_SHORT).show();
            }
        });

        btnVolverAtras_CrearNode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class));
            }
        });

    }
}
