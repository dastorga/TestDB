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

public class NodeListOrigen extends AppCompatActivity {

    ListView ListViewNodo;
    ArrayList<Node> list;
    NodeListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_list);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        final Globals g = Globals.getInstance();
        int idGlobalGraph = g.getIdGlobal();

        ListViewNodo = (ListView) findViewById(R.id.ListViewNodo);

        list = new ArrayList<>();

        adapter = new NodeListAdapter(this, R.layout.node, MDB.recoverNodesInGraph(idGlobalGraph));

        ListViewNodo.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        ListViewNodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Node ListViewClickData = (Node) parent.getItemAtPosition(position);

                Toast.makeText(NodeListOrigen.this, "ID ORIGEN:"+ListViewClickData.getIdNode(), Toast.LENGTH_SHORT).show();

                g.setIdOrigen(ListViewClickData.getIdNode()); // Guardo id_origen

                Intent intentCrearEnlace = new Intent(getApplicationContext(), CrearEnlaceActivity.class);
                startActivity(intentCrearEnlace);
            }
        });

        g.setIdOrigen(0);

    }
}
