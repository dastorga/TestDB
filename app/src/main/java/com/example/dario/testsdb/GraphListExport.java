package com.example.dario.testsdb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class GraphListExport extends AppCompatActivity {

    ListView ListViewGraph;
    GraphListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_list);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        ListViewGraph = (ListView) findViewById(R.id.ListViewGraph);
        adapter = new GraphListAdapter(this, R.layout.graph, MDB.recoverGraphs());
        ListViewGraph.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ListViewGraph.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Graph ListViewClickData = (Graph) parent.getItemAtPosition(position);
                ListViewClickData.getIdGraph();
                Toast.makeText(GraphListExport.this, "GRAFO NUMERO "+ListViewClickData.getIdGraph()+" PARA EXPORTAR", Toast.LENGTH_SHORT).show();

            }
        });

    }
}