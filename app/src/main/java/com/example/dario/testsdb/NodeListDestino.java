package com.example.dario.testsdb;

/**
 * Created by dario on 12/11/17.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class NodeListDestino extends AppCompatActivity {

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
                // Getting Search ListView clicked item.
                Node ListViewClickData = (Node) parent.getItemAtPosition(position);
                // printing clicked item on screen using Toast message.
                Toast.makeText(NodeListDestino.this, "ID DESTINO:"+ListViewClickData.getIdNode(), Toast.LENGTH_SHORT).show();

                g.setIdDestino(ListViewClickData.getIdNode()); // Guardo id_origen
            }
        });


    }
}
