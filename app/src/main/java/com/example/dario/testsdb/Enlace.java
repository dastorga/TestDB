package com.example.dario.testsdb;

/**
 * Created by dario on 22/9/17.
 */

public class Enlace {

    private int id;
    private int origen;
    private int destino;
    private String atributo;
    private int id_graph;

    public Enlace(int id, int origen, int destino, String atributo, int id_graph) {
        this.id = id;
        this.atributo = atributo;
        this.destino = destino;
        this.origen = origen;
        this.id_graph = id_graph;
    }

    public int getIdEnlace() {
        return id;
    }
    public void setIdEnlace(int id) {
        this.id = id;
    }

    public int getOrigenEnlace() {
        return origen;
    }
    public void setOrigenEnlace(int origen) {
        this.origen = origen;
    }

    public int getDestinoEnlace() {
        return destino;
    }
    public void setDestinoEnlace(int destino) {
        this.destino = destino;
    }

    public String getAtributoEnlace() {
        return atributo;
    }
    public void setAtributoEnlace(String atributo) {
        this.atributo = atributo;
    }

    public int getIdGraphEnlace() {
        return id_graph;
    }
    public void setIdGraphEnlace(int id_graph) {
        this.id_graph = id_graph;
    }

}

