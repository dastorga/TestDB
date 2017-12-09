package com.example.dario.testsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * EDITA EL NOMBRE DEL NODO SELECIONADO
 */


public class EditarNombreNodo extends AppCompatActivity {

    Button btnVolver_EditarNodo, btnGuardarCambios_EditarNodo;
    EditText etNombre_EditarNodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_nodo);

        etNombre_EditarNodo = (EditText) findViewById(R.id.etNombre_EditarNodo);

        btnGuardarCambios_EditarNodo = (Button) findViewById(R.id.btnGuardarCambios_EditarNodo);
        btnVolver_EditarNodo = (Button) findViewById(R.id.btnVolver_EditarNodo);

        final MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        Globals g = Globals.getInstance();
        final int idNodeEdit = g.getIdNodeEdit();
        final int idGlobalEdit = g.getIdGlobalEdit();

        etNombre_EditarNodo.setText(MDB.recoverNode(idNodeEdit).getAtributoNode()); // pongo el nombre actual enel campo a editar

        btnGuardarCambios_EditarNodo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MDB.updateNode(idNodeEdit, etNombre_EditarNodo.getText().toString(), idGlobalEdit);
                Toast.makeText(EditarNombreNodo.this, "EDITADO ))", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), NodoListEdit.class));
            }
        });

        btnVolver_EditarNodo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NodoListEdit.class));
            }
        });
    }
}
