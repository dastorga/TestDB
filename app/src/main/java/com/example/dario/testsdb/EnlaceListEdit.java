package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Lista de enlaces, para luego seleccionar uno para editar.
 */

public class EnlaceListEdit extends AppCompatActivity {

    ListView ListViewEnlace;
    ArrayList<Enlace> list;
    EnlaceListAdapter adapter = null;

    // Aqui debere se deben listar todos los enlaces del grafo (idGlobalEdit).
    // luego se debe poder seleccionar un enlace para luego editarlo (atributo por el momento).

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlace_list);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        final Globals g = Globals.getInstance();
        int idGlobalEdit = g.getIdGlobalEdit(); // obtengo el grafo actual a editar

        ListViewEnlace = findViewById(R.id.ListViewEnlace);
        list = new ArrayList<>();
//      adapter = new EnlaceListAdapter(this, R.layout.enlace, MDB.recoverEnlacesInGraph(idGlobalEdit));
        ListViewEnlace.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ListViewEnlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Enlace ListViewClickData = (Enlace) parent.getItemAtPosition(position);
                ListViewClickData.getIdEnlace();

                Toast.makeText(EnlaceListEdit.this, "ENLACE "+ListViewClickData.getIdEnlace()+" A EDITAR", Toast.LENGTH_SHORT).show();
//
//                final Globals g = Globals.getInstance();
//                g.setIdNodeEdit(ListViewClickData.getIdNode()); // guardo el enlace a editar en la variable global
//
//                startActivity(new Intent(getApplicationContext(), EditarEnlace.class));
            }
        });

    }
}
