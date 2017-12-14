package com.example.dario.testsdb;

import android.content.Context;

import java.util.ArrayList;

/**
 * Clase distinada a facilitar diferentes construcciones de grafos.
 */

public class ConstructionGraph {

    private Context context;

    /**
     * Constructor de la clase con contexto.
     */
    public ConstructionGraph(Context context) {
        this.context = context;
    }


    /**
     * Dado un identificador de grafo (idGrafo), me retorna como resultado todos sus nodos como una sola cadena de string.
     */
    public String ConstrucctionNodesString(int idGraph){
        final MiBaseDatos MDB = new MiBaseDatos(context);
        ArrayList<Node> lista_nodes = MDB.recoverNodesInGraph(idGraph);
        String lista_nodes_string = ""; //Inicializo en vacio
        for(int i = 0; i< lista_nodes.size(); i++){
            //Aqui armo una cadena de los atributos de todos los nodos del grafo que se pasa como parametro
            lista_nodes_string = lista_nodes_string + " " +lista_nodes.get(i).getAtributoNode();
        }
        return lista_nodes_string;
    }


}
