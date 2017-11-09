package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dario on 9/11/17.
 */

public class NodeList extends AppCompatActivity {

    List<Node> list;
    ListView ListViewPrimerNodo;
    NodeListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primer_nodo);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        ListViewPrimerNodo = (ListView) findViewById(R.id.ListViewPrimerNodo);

        adapter = new NodeListAdapter(this, R.layout.node, (ArrayList<Node>) list);
        ListViewPrimerNodo.setAdapter(adapter);

        Globals g = Globals.getInstance();
        int idGlobalGraph = g.getIdGlobal();

        list.clear();
        //Me retorna una lista de todos los nodos del grafo que paso como parametro.
        list = (List<Node>) MDB.recoverNodesInGraph(idGlobalGraph);

        adapter.notifyDataSetChanged();

    }

}
