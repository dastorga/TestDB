package com.example.dario.testsdb;

public class Globals {
    // values around the life cycle of the application regardless which activity running..

    private static Globals instance;
    private static int idGlobal;
    private static int idGlobalEdit;

    private static int idNodeEdit;

    private static int idOrigen;
    private static int idDestino;

    public Globals( ) { }

    public void setIdGlobal(int t) {
        Globals.idGlobal = t;
    }

    public int getIdGlobal() {
        return Globals.idGlobal;
    }


    public void setIdOrigen(int idOrigen) {
        Globals.idOrigen = idOrigen;
    }

    public int getIdOrigen() {
        return Globals.idOrigen;
    }


    public void setIdDestino(int idDestino) {
        Globals.idDestino = idDestino;
    }

    public int getIdDestino() {return Globals.idDestino;}


    public void setIdGlobalEdit(int idGlobalEdit) { Globals.idGlobalEdit = idGlobalEdit; }

    public int getIdGlobalEdit() { return Globals.idGlobalEdit; }


    public void setIdNodeEdit(int idNodeEdit) {
        Globals.idNodeEdit = idNodeEdit;
    }

    public int getIdNodeEdit() {
        return Globals.idNodeEdit;
    }

    public static synchronized Globals getInstance(){
        if (instance==null){
            instance=new Globals();
        }
        return instance;
    }

}

