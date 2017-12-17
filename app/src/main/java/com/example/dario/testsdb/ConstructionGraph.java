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
        final MiBaseDatos MDB = new MiBaseDatos(context); // La paso el contexto que traigo al invocar esta clase
        ArrayList<Node> lista_nodes = MDB.recoverNodesInGraph(idGraph);
        String lista_nodes_string = ""; //Inicializo en vacio, variable para almacenar el resultado final.
        for(int i = 0; i< lista_nodes.size(); i++){
            //Aqui armo una cadena de los atributos de todos los nodos del grafo que se pasa como parametro
            lista_nodes_string = lista_nodes_string + " " +lista_nodes.get(i).getAtributoNode();
        }
        return lista_nodes_string;
    }

    /**
     * Dado un identificador de grafo (idGrafo),
     */
    public String ConstrucctionEnlacesString(int idGraph){
        final MiBaseDatos MDB = new MiBaseDatos(context); // La paso el contexto que traigo al invocar esta clase
        return "";
    }

}
