package com.example.dario.testsdb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Lista de enlaces, para luego seleccionar uno para editargrafo.
 */

public class EnlaceListEdit extends AppCompatActivity {

    ListView ListViewEnlace;
    ArrayList<Enlace> list;
    EnlaceListAdapter adapter = null;
    MediaPlayer noahienlacesparaeditar;

    // Aqui debere se deben listar todos los enlaces del grafo (idGlobalEdit) seleccionado.
    // Luego se debe poder seleccionar un enlace para luego editarlo (atributo por el momento).

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlace_list);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        final Globals g = Globals.getInstance();
        int idGlobalEdit = g.getIdGlobalEdit(); // obtengo el grafo actual a editargrafo

        ListViewEnlace = findViewById(R.id.ListViewEnlace);
        list = new ArrayList<>();
        adapter = new EnlaceListAdapter(this, R.layout.enlace, MDB.recoverEnlacesInGraph(idGlobalEdit));
        ListViewEnlace.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        noahienlacesparaeditar = MediaPlayer.create(this, R.raw.noahienlacesparaeditar);

        if (MDB.recoverEnlacesInGraph(idGlobalEdit).size() == 0) {
            if (g.getSonidoActivado()){noahienlacesparaeditar.start();}
        }

        ListViewEnlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Enlace ListViewClickData = (Enlace) parent.getItemAtPosition(position);
                ListViewClickData.getIdEnlace();

                Toast.makeText(EnlaceListEdit.this, "ENLACE "+ListViewClickData.getIdEnlace()+" A EDITAR", Toast.LENGTH_SHORT).show();

                final Globals g = Globals.getInstance();
                g.setIdEnlaceEdit(ListViewClickData.getIdEnlace()); // guardo el enlace a editargrafo en la variable global

                startActivity(new Intent(getApplicationContext(), EditarEnlace.class));
            }
        });

    }
}
