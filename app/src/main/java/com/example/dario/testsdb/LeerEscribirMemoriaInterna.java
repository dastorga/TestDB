package com.example.dario.testsdb;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by dario on 6/5/18.
 */

public class LeerEscribirMemoriaInterna extends AppCompatActivity {

    boolean sdDisponible = false;
    boolean sdAccesoEscritura = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Código que me comprueba si existe SD y si puedo escribir o no
        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED))
        {
            sdDisponible = true;
            sdAccesoEscritura = true;
        }
        else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            sdDisponible = true;
            sdAccesoEscritura = false;
        }
        else
        {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }

    }

    public String leermeminterna(){
        String texto = "";
        try
        {
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("meminterna.txt")));
            texto = fin.readLine();
            Toast.makeText(LeerEscribirMemoriaInterna.this, "Leo correctamente"  , Toast.LENGTH_SHORT).show();
            fin.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde la memoria interna");
        }
        return texto;
    }

    public void escribirmeminterna(String grafo){
        try
        {
            OutputStreamWriter fout= new OutputStreamWriter(openFileOutput("meminterna.txt", Context.MODE_PRIVATE));
            fout.write(grafo); // guardo el grafo
            Toast.makeText(LeerEscribirMemoriaInterna.this, "Escribi correctamente"  , Toast.LENGTH_SHORT).show();
            fout.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero en la memoria interna");
        }

    }

    public String leersd() {
        String texto = "";
        if (sdDisponible) {
            try {
                File ruta_sd = Environment.getExternalStorageDirectory();

                File f = new File(ruta_sd.getAbsolutePath(), "ficherosd.txt");

                BufferedReader fin =
                        new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(f)));

                texto = fin.readLine();
                fin.close();
            } catch (Exception ex) {
                Log.e("Ficheros", "Error al leer fichero desde tarjeta SD");
            }
        }
        return texto;
    }

    public void escribirsd(){
        if(sdAccesoEscritura && sdDisponible){
            try
            {
                File ruta_sd = Environment.getExternalStorageDirectory();

                File f = new File(ruta_sd.getAbsolutePath(), "ficherosd.txt");

                OutputStreamWriter fout =
                        new OutputStreamWriter(
                                new FileOutputStream(f));

                fout.write("Contenido del fichero de la SD");
                fout.close();
            }
            catch (Exception ex)
            {
                Log.e("Ficheros", "Error al escribir fichero en la tarjeta SD");
            }
        }
    }

//    public  void leerprograma(){
//        try
//        {
//            InputStream fraw = getResources().openRawResource(R.raw.ficheroraw);
//
//            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
//
//            String linea = brin.readLine();
//            textView.setText(linea);
//
//            fraw.close();
//        }
//        catch (Exception ex)
//        {
//            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
//        }
//    }

}


