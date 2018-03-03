package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Clase encargada de mostrar todos los nodos y receptar o no el nodo origen.
 */

public class ListNodosUpdateOrigen extends AppCompatActivity {

    ListView ListViewNodo;
    ArrayList<Node> list;
    NodeListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_list);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        final Globals g = Globals.getInstance();
        int idGlobalEdit = g.getIdGlobalEdit(); // obtengo el grafo actual a editar

        ListViewNodo = findViewById(R.id.ListViewNodo);
        list = new ArrayList<>();
        adapter = new NodeListAdapter(this, R.layout.node, MDB.recoverNodesInGraph(idGlobalEdit));
        ListViewNodo.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ListViewNodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Node ListViewClickData = (Node) parent.getItemAtPosition(position);
                ListViewClickData.getIdNode();

                Toast.makeText(ListNodosUpdateOrigen.this, "NODO "+ListViewClickData.getIdNode()+" SELECCIONADO", Toast.LENGTH_SHORT).show();

                final Globals g = Globals.getInstance();
                g.setIdOrigenEdit(ListViewClickData.getIdNode()); // guardo el nodo origen a editar en la variable global

                startActivity(new Intent(getApplicationContext(), EditarEnlace.class));
            }
        });

    }
}