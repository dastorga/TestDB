package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class EditarNodoGrafo extends AppCompatActivity {

    ListView ListViewNodo;
    ArrayList<Node> list;
    NodeListAdapter adapter = null;

    // Aqui debere se deben listar todos los nodos del grafo (idGlobalEdit).
    // luego se debe poder seleccionar uno para luego terminar editandolo (solo el atributo se puede editar, or el momento debido a que no posee otra cosa).

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_list);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        final Globals g = Globals.getInstance();
        int idGlobalEdit = g.getIdGlobalEdit();

        ListViewNodo = (ListView) findViewById(R.id.ListViewNodo);
        list = new ArrayList<>();
        adapter = new NodeListAdapter(this, R.layout.node, MDB.recoverNodesInGraph(idGlobalEdit));
        ListViewNodo.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ListViewNodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Node ListViewClickData = (Node) parent.getItemAtPosition(position);
                ListViewClickData.getIdNode();
            }
        });

    }
}