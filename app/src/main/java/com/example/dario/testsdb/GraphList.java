package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class GraphList extends AppCompatActivity {

    ListView ListViewGraph;
    ArrayList<Graph> list;
    GraphListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_list);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        final Globals g = Globals.getInstance();
        int idGlobalGraph = g.getIdGlobal();

        ListViewGraph = (ListView) findViewById(R.id.ListViewGraph);

        list = new ArrayList<>();

        //Probablemente deba pasar todo a arraylist!!!!
        adapter = new GraphListAdapter(this, R.layout.graph, (ArrayList<Graph>) MDB.recoverGraphs());

        ListViewGraph.setAdapter(adapter);

        adapter.notifyDataSetChanged();


    }

}
