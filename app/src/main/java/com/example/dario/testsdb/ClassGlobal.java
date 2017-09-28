package com.example.dario.testsdb;

import android.app.Application;

/**
 * Created by dario on 28/9/17.
 */

public class ClassGlobal extends Application {
    // values around the life cycle of the application regardless which activity running..

    private int idGlobal;

    public int getIdGlobal() {
        return idGlobal;
    }

    public void setIdGlobal(int idGlobal) {
        this.idGlobal = idGlobal;
    }
}

