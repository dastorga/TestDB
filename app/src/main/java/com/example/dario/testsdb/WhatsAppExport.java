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

        //final String number = String.valueOf(editText_telefono_whatsapp.getText()); // obtengo el numero que se ingreso, se valida como type phone
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
                //Toast.makeText(WhatsAppExport.this, constructionGraphString  , Toast.LENGTH_SHORT).show();
                //Log.i("------------------->", constructionGraphString);

                // Me abre WhatsApp directamente
                //Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                //startActivity(launchIntent);

                if(editText_telefono_whatsapp.getText().toString().trim().equalsIgnoreCase("")){
                    // Opcion en la que no inserta ningun numero, el campo esta vacio.
                    // Se abre el panel de opciones para enviar donde nos paresca mejor
                    // por email, por WhatsApp, etc.
                    Toast.makeText(WhatsAppExport.this, "No has introducido numero", Toast.LENGTH_SHORT).show();
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Ingresa a: https://dreampuf.github.io/GraphvizOnline/ y pega el siguiente grafo:"+"\n"+constructionGraphString);
                    //sendIntent.putExtra(Intent.EXTRA_TEXT, constructionGraphString);
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                } else {
                    // Opcion en la que inserta numero de telefono, se busca el contacto en WhatsApp y se le envia el mensaje.
                    //Toast.makeText(WhatsAppExport.this, editText_telefono_whatsapp.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    String uri = "whatsapp://send?phone=" + editText_telefono_whatsapp.getText().toString() + "&text=" +"http://graphviz.it/#/"+ constructionGraphString;
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                }
            }
        });

        /**
         * Me retorna a la activity anterior, osea el menu principal.
         *
         */
        btn_volver_inicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}