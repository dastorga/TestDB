package com.example.dario.testsdb;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Clase distinada a facilitar diferentes construcciones de grafos.
 * Tambien diferentes recorridos (futuro).
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
     * Dado un identificador de grafo (idGrafo), me retorna como resultado el grafo pasado a string para su posterior reproduccion.
     */
    public String ConstructionGraphTotalString(int idGraph){
        final MiBaseDatos MDB = new MiBaseDatos(context); // La paso el contexto que traigo al invocar esta clase
        String listaDeEnlaces= ConstrucctionEnlacesStringParaGrafo(idGraph);

        String nameGraph = MDB.recoverGraph(idGraph).getNameGraph(); //nombre del grafo
        String resultadoFinal;
        resultadoFinal = "Grafo llamado" + nameGraph + " " + "\n" + "enlaces " +listaDeEnlaces + "\n" + " ";
        return resultadoFinal;
    }

    /**
     * Dado un identificador de grafo (idGrafo), me retorna como resultado los enlaces acomodados para armar el grafo total.
     */
    public String ConstrucctionEnlacesStringParaGrafo(int idGraph){
        final MiBaseDatos MDB = new MiBaseDatos(context); // La paso el contexto que traigo al invocar esta clase
        String resultFinal = "";
        ArrayList<Enlace> arrayListEnlaces = MDB.recoverEnlacesInGraph(idGraph);
        for(int i = 0; i< arrayListEnlaces.size(); i++){
            String cadena = new String("nodo " + MDB.recoverNode(arrayListEnlaces.get(i).getOrigenEnlace()).getAtributoNode() + " implica "+ "nodo "+
                    MDB.recoverNode(arrayListEnlaces.get(i).getDestinoEnlace()).getAtributoNode() + "\n");
            resultFinal+= cadena;
        }
        //Log.i("TODOS LOS ENLACES     ", resultFinal);
        return resultFinal;
    }


    /**
     * Dado un identificador de grafo (idGrafo), me retorna como resultado todos sus nodos como una sola cadena de string.
     */
    public String ConstrucctionNodesString(int idGraph){
        final MiBaseDatos MDB = new MiBaseDatos(context); // La paso el contexto que traigo al invocar esta clase
        ArrayList<Node> lista_nodes = MDB.recoverNodesInGraph(idGraph);
        String lista_nodes_string = "Lista de Nodos"+"\n"; //Inicializo en vacio, variable para almacenar el resultado final.
        for(int i = 0; i< lista_nodes.size(); i++){
            //Aqui armo una cadena de los atributos de todos los nodos del grafo que se pasa como parametro
            lista_nodes_string = lista_nodes_string + " " +lista_nodes.get(i).getAtributoNode();
        }
        return lista_nodes_string;
    }

    /**
     * Aqui la idea seria poder construir todos los enlaces del grafo que se pasa como parametro,
     * luego devolver como resultado en un string todos los enlaces de ese grafo, en un string.
     *
     * Ejemplo:
     *
     *      A -> B
     *      A -> A
     *      B -> C
     *      C -> A
     *
     *      Asi obtengo el nodo origen del enlace y del destino
     *      resultFinal = arrayListEnlaces.get(i).getOrigenEnlace() + "->"+ arrayListEnlaces.get(i).getDestinoEnlace() + "\n";
     */
    public String ConstrucctionEnlacesString(int idGraph){
        final MiBaseDatos MDB = new MiBaseDatos(context); // La paso el contexto que traigo al invocar esta clase
        String resultFinal = "";
        ArrayList<Enlace> arrayListEnlaces = MDB.recoverEnlacesInGraph(idGraph);
        for(int i = 0; i< arrayListEnlaces.size(); i++){
            String cadena = new String(MDB.recoverNode(arrayListEnlaces.get(i).getOrigenEnlace()).getAtributoNode() + "->"+
                    MDB.recoverNode(arrayListEnlaces.get(i).getDestinoEnlace()).getAtributoNode() + "\n");
            resultFinal+= cadena;
        }
        Log.i("TODOS LOS ENLACES     ", resultFinal);
        return resultFinal;
    }


    /**
     * Dado un identificador de grafo (idGrafo), me retorna como resultado el grafo completo en en formato Graphviz
     * Es condicion necesaria hacer uso del metodo "ConstrucctionEnlacesString" quien me retorna la construccion de
     * enlaces uno debajo el otro.
     * Ejemplo:
     *
     *  digraph G {
     *  A -> B
     *  B -> C
     *  C -> A
     *
     *  }
     *
     */
    public String ConstructionGraphString(int idGraph){
        final MiBaseDatos MDB = new MiBaseDatos(context); // La paso el contexto que traigo al invocar esta clase
        String listaDeEnlaces= ConstrucctionEnlacesString(idGraph);
        String nameGraph = MDB.recoverGraph(idGraph).getNameGraph(); //nombre del grafo
        String resultadoFinal;
        resultadoFinal = "digraph " + nameGraph + " {" + "\n" + listaDeEnlaces + "\n" + "}";
        return resultadoFinal;
    }

}
