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
 * Edita el nodo del nodo seleccionado.
 */


public class EditarNodo extends AppCompatActivity {

    Button btnVolver_EditarNodo, btnGuardarCambios_EditarNodo, btnEliminarNodo_ClassEditarNodo;
    EditText etNombre_EditarNodo;
    MediaPlayer clicksuccess, volver, volveratras, nodoeliminado;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_nodo);

        etNombre_EditarNodo = findViewById(R.id.etNombre_EditarNodo);
        btnGuardarCambios_EditarNodo = findViewById(R.id.btnGuardarCambios_EditarNodo);
        btnEliminarNodo_ClassEditarNodo = findViewById(R.id.btnEliminarNodo_ClassEditarNodo);
        btnVolver_EditarNodo = findViewById(R.id.btnVolver_EditarNodo);
        clicksuccess = MediaPlayer.create(this, R.raw.clicksuccess);
        volver = MediaPlayer.create(this, R.raw.volver);
        volveratras = MediaPlayer.create(this, R.raw.volveratras);
        nodoeliminado = MediaPlayer.create(this, R.raw.nodoeliminado);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        final Globals g = Globals.getInstance();
        final int idNodeEdit = g.getIdNodeEdit();
        final int idGlobalEdit = g.getIdGlobalEdit();

        etNombre_EditarNodo.setText(MDB.recoverNode(idNodeEdit).getAtributoNode()); // pongo el nombre actual en el campo a editargrafo

        btnGuardarCambios_EditarNodo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MDB.updateNode(idNodeEdit, etNombre_EditarNodo.getText().toString(), idGlobalEdit);
                Toast.makeText(EditarNodo.this, "EDITADO ))", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), NodoListEdit.class));
                if (g.getVibrateActivado()){vibrator.vibrate(800);}
                if (g.getSonidoActivado()){clicksuccess.start();}
            }
        });

        btnEliminarNodo_ClassEditarNodo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Aqui si elimino el nodo, deberia eliminargrafo los enlaces que lo refieren y a los que el refiere.
                MDB.deleteNode(idNodeEdit);
                Toast.makeText(EditarNodo.this, "ELIMINADO ))", Toast.LENGTH_SHORT).show();
                if (g.getSonidoActivado()){nodoeliminado.start();}
                startActivity(new Intent(getApplicationContext(), NodoListEdit.class));
            }
        });

        btnVolver_EditarNodo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NodoListEdit.class));
                if (g.getVibrateActivado()){vibrator.vibrate(400);}
                if (g.getSonidoActivado()){volver.start();}
                if (g.getSonidoActivado()){volveratras.start();}
            }
        });
    }
}
