package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Lista todos los grafos, para luego seleccionar
 * uno para poder eliminarlo de la base de datos en (cascade).
 */

public class GraphListDelete extends AppCompatActivity {

    ListView ListViewGraph;
    GraphListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_list);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        ListViewGraph = findViewById(R.id.ListViewGraph);
        adapter = new GraphListAdapter(this, R.layout.graph, MDB.recoverGraphs());
        ListViewGraph.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ListViewGraph.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Graph ListViewClickData = (Graph) parent.getItemAtPosition(position);
                // MDB.deleteGraph(ListViewClickData.getIdGraph());
                Intent intent = new Intent(getApplicationContext(), WarningNotice.class);
                intent.putExtra("id_graph", String.valueOf(ListViewClickData.getIdGraph()));
                startActivity(intent);
            }
        });


    }
}