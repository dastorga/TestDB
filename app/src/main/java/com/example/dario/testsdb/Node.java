package com.example.dario.testsdb;

/**
 * Created by dario on 22/9/17.
 */

public class Node {

    private int id;
    private int codigo;
    private String atributo;
    private int id_graph;

    public Node(int id, int codigo, String atributo, int id_graph) {
        this.id = id;
        this.codigo = codigo;
        this.atributo = atributo;
        this.id_graph = id_graph;
    }

    public int getIdNode() {
        return id;
    }
    public void setIdNode(int id) {
        this.id = id;
    }

    public int getCodigoNode() {
        return codigo;
    }
    public void setCodigoNode(int codigo) {
        this.codigo = codigo;
    }

    public String getAtributoNode() {
        return atributo;
    }
    public void setAtributoNode(String atributo) {
        this.atributo = atributo;
    }

    public int getIdGraphNode() {
        return id_graph;
    }
    public void setIdGraphNode(int id_graph) {
        this.id_graph = id_graph;
    }

}
