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

public class CrearEnlaceActivity extends AppCompatActivity {

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

        btnNodoOrigen_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar una lista de nodos creados
                Intent intentNodeList = new Intent(CrearEnlaceActivity.this, NodeListOrigen.class);
                startActivity(intentNodeList);
            }
        });

        btnNodoDestino_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Aqui debo mostrar una lista de nodos creados
                Intent intentNodeList = new Intent(CrearEnlaceActivity.this, NodeListDestino.class);
                startActivity(intentNodeList);
            }
        });


        btnCrearArco_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String atributo = editTextGuardarAtributo.getText().toString();
                Toast.makeText(CrearEnlaceActivity.this, atributo , Toast.LENGTH_SHORT).show();

                if ( g.getIdOrigen() == 0 && g.getIdDestino() != 0){
                    Toast.makeText(CrearEnlaceActivity.this, "NO AHI ORIGEN SELECCIONADO ))", Toast.LENGTH_SHORT).show();
                    if (g.getSonidoActivado()){error.start();}
                    if (g.getSonidoActivado()){noahinodoorigenseleccionado.start();}

                }
                if ( g.getIdOrigen() != 0 && g.getIdDestino() == 0){
                    Toast.makeText(CrearEnlaceActivity.this, "NO AHI DESTINO SELECCIONADO ))", Toast.LENGTH_SHORT).show();
                    if (g.getSonidoActivado()){error.start();}
                    if (g.getSonidoActivado()){noahinododestinoseleccionado.start();}
                }
                if ( g.getIdOrigen() == 0 && g.getIdDestino() == 0){
                    Toast.makeText(CrearEnlaceActivity.this, "NO AHI NI ORIGEN NI DESTINO SELECCIONADO", Toast.LENGTH_SHORT).show();
                    if (g.getSonidoActivado()){error.start();}
                }

                if ( g.getIdOrigen() != 0 && g.getIdDestino() != 0){
                    Toast.makeText(CrearEnlaceActivity.this, "ORIGEN: " + g.getIdOrigen() + " -> DESTINO: " + g.getIdDestino(), Toast.LENGTH_SHORT).show();
                    int numeroEnlace = MDB.insertEnlace(g.getIdOrigen(), g.getIdDestino(), atributo, g.getIdGlobal());
                    g.setIdOrigen(0);
                    g.setIdDestino(0);
                    Toast.makeText(CrearEnlaceActivity.this, "ENLACE CREADO NUMERO: "+ numeroEnlace, Toast.LENGTH_SHORT).show();
                    editTextGuardarAtributo.setText(""); // limpio el campo ediText
                    if (g.getVibrateActivado()){vibrator.vibrate(800);}
                    if (g.getSonidoActivado()){clicksuccess.start();}
                    if (g.getSonidoActivado()){enlacecreado.start();}
                }
            }
        });

        btnVolverAtras_CrearArco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearNodeEnlaceActivity.class));
                if (g.getSonidoActivado()){volver.start();}
                if (g.getSonidoActivado()){volveratras.start();}
            }
        });

    }

}


