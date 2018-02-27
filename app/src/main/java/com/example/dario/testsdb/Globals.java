package com.example.dario.testsdb;

/**
 * Variables globales con valores alrededor del ciclo de vida de la aplicación,
 * independientemente de la actividad que se ejecute.
 */

public class Globals {
    // values around the life cycle of the application regardless which activity running..

    private static Globals instance;
    private static int idGlobal;

    private static int idGlobalEdit;
    private static int idNodeEdit;

    private static int idOrigen;
    private static int idDestino;

    private static int idGlobalPlay;

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


    public void setIdGlobalPlay(int idGlobalPlay) {
        Globals.idGlobalPlay = idGlobalPlay;
    }

    public int getIdGlobalPlay() {
        return Globals.idGlobalPlay;
    }

    public static synchronized Globals getInstance(){
        if (instance==null){
            instance=new Globals();
        }
        return instance;
    }

}

