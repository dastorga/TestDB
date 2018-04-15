package com.example.dario.testsdb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Esta clase se encargara de exportar el grafo seleccionado con anterioridad y exportarlo al numero de WhatsApp ingresado
 * en el campo de texto
 */

public class WhatsAppExport extends AppCompatActivity {

    Button btn_volver_inicio, btn_enviar_whatsapp;
    EditText editText_telefono_whatsapp;
    ConstructionGraph c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp_export);

        btn_volver_inicio = findViewById(R.id.btn_volver_inicio);
        editText_telefono_whatsapp = findViewById(R.id.editText_telefono_whatsapp);
        btn_enviar_whatsapp = findViewById(R.id.btn_enviar_whatsapp);

        final String number = String.valueOf(editText_telefono_whatsapp.getText()); // obtengo el numero que se ingreso, se valida como type phone
                                             // luego aqui yo lo paso a text.

        final Globals g = Globals.getInstance();
        final int idGlobalPlay = g.getIdGlobalPlay(); // Obtengo el id del grafo actual para reproducir

        btn_enviar_whatsapp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * Mi idea en esta instancia es, armar el grafo de manera correcta en formato "dot" y almacenarlo en una variable string
                 * temporal.
                 * Luego, una vez obtenido el numero de telefono, enviar por WhatsApp el link, el cual la persona vidente recibe.
                 * Una vez recibido este link, solo le resta presionar sobre el mismo, pudiendo asi ver el grafo completo
                 * de manera grafica y online, con graphviz.
                 *
                 * Debo pasar el grafo listo por URL, asi la pagina solo lo levanta y muestra el grafo.
                 *
                 * Tambien probar correctamente la API de WhatsApp, para chequear seguridad, velocidad, en los envios de link's.
                 */

                c = new ConstructionGraph(getApplicationContext()); // Paso contexto actual
                String constructionGraphString = c.ConstructionGraphString(idGlobalPlay); // paso id del grafo a construir
//                Toast.makeText(WhatsAppExport.this, constructionGraphString  , Toast.LENGTH_SHORT).show();
//                Log.i("------------------->", constructionGraphString);

                // Me abre WhatsApp directamente
                //Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                //startActivity(launchIntent);

                if(number == ""){
                    // Opcion en la que no inserta ningun numero
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "http://graphviz.it/#/new"+constructionGraphString);
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                } else {
                    // Opcion en la que inserta numero de telefono
                    Toast.makeText(WhatsAppExport.this, number, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    String uri = "whatsapp://send?phone=" + number + "&text=" + constructionGraphString;
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);

                    Toast.makeText(WhatsAppExport.this, "Enviado exitosamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_volver_inicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}