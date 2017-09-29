package com.example.dario.testsdb;

/**
 * Created by dario on 28/9/17.
 */

public class ClassGlobals {
    // values around the life cycle of the application regardless which activity running..

    private static ClassGlobal instance;

    private static int idGlobal;

    public ClassGlobal( ) { }

    public void setIdGlobal(int t) {
        ClassGlobal.idGlobal = t;
    }

    public int getIdGlobal() {
        return ClassGlobal.idGlobal;
    }


    public static synchronized ClassGlobal
}

