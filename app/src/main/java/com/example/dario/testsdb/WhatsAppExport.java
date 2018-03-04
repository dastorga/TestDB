package com.example.dario.testsdb;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp_export);

        btn_volver_inicio = findViewById(R.id.btn_volver_inicio);
        editText_telefono_whatsapp = findViewById(R.id.editText_telefono_whatsapp);
        btn_enviar_whatsapp = findViewById(R.id.btn_enviar_whatsapp);

        editText_telefono_whatsapp.getText(); // obtengo el numero que se ingreso, pero lo tomo como texto

        btn_enviar_whatsapp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(WhatsAppExport.this, "Enviado exitosamente!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_volver_inicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}