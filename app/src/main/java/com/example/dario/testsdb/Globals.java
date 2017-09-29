package com.example.dario.testsdb;

/**
 * Created by dario on 28/9/17.
 */

public class Globals {
    // values around the life cycle of the application regardless which activity running..

    private static Globals instance;

    private static int idGlobal;

    public Globals( ) { }

    public void setIdGlobal(int t) {
        Globals.idGlobal = t;
    }

    public int getIdGlobal() {
        return Globals.idGlobal;
    }

    public static synchronized Globals getInstance(){
        if (instance==null){
            instance=new Globals();
        }
        return instance;
    }

}

