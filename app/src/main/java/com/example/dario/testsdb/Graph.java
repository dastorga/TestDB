package com.example.dario.testsdb;

public class Graph {
    private int id;
    private String name;

    public Graph(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getIdGraph() {
        return id;
    }

    public void setIdGraph(int id) {
        this.id = id;
    }

    public String getNameGraph() {
        return name;
    }

    public void setNameGraph(String name) {this.name = name;}
}
