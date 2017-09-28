package com.example.dario.testsdb;

import android.app.Application;

/**
 * Created by dario on 28/9/17.
 */

public class ClassGlobal extends Application {
    // values around the life cycle of the application regardless which activity running..

    private int idGlobal;

    public ClassGlobal(int idGlobal ) {
        this.idGlobal = idGlobal;
    }

    public ClassGlobal( ) {
        super();
    }

    public int getIdGlobal() {
        return idGlobal;
    }

    public int setIdGlobal(int idGlobal) {
        this.idGlobal = idGlobal;
        return idGlobal;
    }
}

