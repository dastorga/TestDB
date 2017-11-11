package com.example.dario.testsdb;

public class Node {

    private int id;
    private String atributo;
    private int id_graph;

    public Node(int id, String atributo, int id_graph) {
        this.id = id;
        this.atributo = atributo;
        this.id_graph = id_graph;
    }

    public int getIdNode() {return id;}

    public void setIdNode(int id) {
        this.id = id;
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
