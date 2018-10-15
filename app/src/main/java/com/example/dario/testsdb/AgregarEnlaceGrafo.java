package com.example.dario.testsdb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by dario on 6/6/18.
 * clase encargada de agregar un enlaca al grafo que se eligio editar, y que se pasa como parametro.
 */

public class AgregarEnlaceGrafo extends AppCompatActivity {

    Button btnNodoOrigen_CrearArco, btnNodoDestino_CrearArco, btnVolverAtras_CrearArco, btnCrearArco_CrearArco;
    EditText editTextGuardarAtributo;
    MediaPlayer clicksuccess, volver, error, noahinodoorigenseleccionado, noahinododestinoseleccionado, enlacecreado, volveratras;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_enlace);

        btnNodoOrigen_CrearArco = findViewById(R.id.btnNodoOrigen_CrearArco);
        btnNodoDestino_CrearArco = findViewById(R.id.btnNodoDestino_CrearArco);
        btnVolverAtras_CrearArco = findViewById(R.id.btnVolverAtras_CrearArco);
        btnCrearArco_CrearArco = findViewById(R.id.btnCrearArco_CrearArco);
        editTextGuardarAtributo = findViewById(R.id.editTextGuardarAtributo);

        clicksuccess = MediaPlayer.create(this, R.raw.clicksuccess);
        noahinodoorigenseleccionado = MediaPlayer.create(this, R.raw.noahinodoorigenseleccionado);
        noahinododestinoseleccionado = MediaPlayer.create(this, R.raw.noahinododestinoseleccionado);
        enlacecreado = MediaPlayer.create(this, R.raw.enlacecreado);
        volveratras = MediaPlayer.create(this, R.raw.volveratras);
        volver = MediaPlayer.create(this, R.raw.volver);
        error = MediaPlayer.create(this, R.raw.error);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        final Globals g = Globals.getInstance();
        final int idGlobalEdit = g.getIdGlobalEdit();

        btnNodoOrigen_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar una lista de nodos creados
                Intent intentNodeList = new Intent(AgregarEnlaceGrafo.this, NodeListOrigenAgregarEnlace.class);
                startActivity(intentNodeList);
            }
        });

        btnNodoDestino_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar una lista de nodos creados
                Intent intentNodeList = new Intent(AgregarEnlaceGrafo.this, NodeListDestinoAgregarEnlace.class);
                startActivity(intentNodeList);
            }
        });


        btnCrearArco_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String atributo = editTextGuardarAtributo.getText().toString();
                Toast.makeText(AgregarEnlaceGrafo.this, atributo , Toast.LENGTH_SHORT).show();

                if ( g.getIdOrigen() == 0 && g.getIdDestino() != 0){
                    Toast.makeText(AgregarEnlaceGrafo.this, "NO AHI ORIGEN SELECCIONADO ))", Toast.LENGTH_SHORT).show();
                    if (g.getSonidoActivado()){error.start();}
                    if (g.getSonidoActivado()){noahinodoorigenseleccionado.start();}

                }
                if ( g.getIdOrigen() != 0 && g.getIdDestino() == 0){
                    Toast.makeText(AgregarEnlaceGrafo.this, "NO AHI DESTINO SELECCIONADO ))", Toast.LENGTH_SHORT).show();
                    if (g.getSonidoActivado()){error.start();}
                    if (g.getSonidoActivado()){noahinododestinoseleccionado.start();}
                }
                if ( g.getIdOrigen() == 0 && g.getIdDestino() == 0){
                    Toast.makeText(AgregarEnlaceGrafo.this, "NO AHI NI ORIGEN NI DESTINO SELECCIONADO", Toast.LENGTH_SHORT).show();
                    if (g.getSonidoActivado()){error.start();}
                }

                if ( g.getIdOrigen() != 0 && g.getIdDestino() != 0){
                    Toast.makeText(AgregarEnlaceGrafo.this, "ORIGEN: " + g.getIdOrigen() + " -> DESTINO: " + g.getIdDestino(), Toast.LENGTH_SHORT).show();
                    int numeroEnlace = MDB.insertEnlace(g.getIdOrigen(), g.getIdDestino(), atributo, g.getIdGlobal());
                    g.setIdOrigen(0);
                    g.setIdDestino(0);
                    Toast.makeText(AgregarEnlaceGrafo.this, "ENLACE CREADO NUMERO: "+ numeroEnlace, Toast.LENGTH_SHORT).show();
                    editTextGuardarAtributo.setText(""); // limpio el campo ediText
                    if (g.getSonidoActivado()){clicksuccess.start();}
                    if (g.getSonidoActivado()){enlacecreado.start();}
                }
            }
        });

        btnVolverAtras_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EditarGrafo.class));
                if (g.getVibrateActivado()){vibrator.vibrate(400);}
                if (g.getSonidoActivado()){volver.start();}
                if (g.getSonidoActivado()){volveratras.start();}
            }
        });

    }

}
