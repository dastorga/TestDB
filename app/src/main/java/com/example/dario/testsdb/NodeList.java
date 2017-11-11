package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by dario on 9/11/17.
 */

public class NodeList extends AppCompatActivity {

    ListView ListViewPrimerNodo;
    ArrayList<Node> list;
    NodeListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primer_nodo);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        Globals g = Globals.getInstance();
        int idGlobalGraph = g.getIdGlobal();

        ListViewPrimerNodo = (ListView) findViewById(R.id.ListViewPrimerNodo);

        list = new ArrayList<>();

        adapter = new NodeListAdapter(this, R.layout.node, MDB.recoverNodesInGraph(idGlobalGraph));

        ListViewPrimerNodo.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }
}
