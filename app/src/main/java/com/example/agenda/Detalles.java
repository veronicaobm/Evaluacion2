package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.agenda.contacto.Contactos;
import com.example.agenda.contacto.ListaContactos;

import java.io.Serializable;

public class Detalles extends AppCompatActivity {
    public Contactos contactos;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent = getIntent();
        int id = (Integer) intent.getExtras().get("idContactos");

        contactos = ListaContactos.getInstancia().getContactos(id);

        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtNombre.setText("Nombre: " +contactos.getNombre());

        TextView txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtTelefono.setText("Telefono: " + contactos.getTelefono());

        TextView txtDireccion = (TextView) findViewById(R.id.txtDireccion);
        txtDireccion.setText("Direccion: " + contactos.getDireccion());

        TextView txtCorreo = (TextView) findViewById(R.id.txtCorreo);
        txtCorreo.setText("Correo: " + contactos.getCorreo());

        Button Editar = (Button) findViewById(R.id.btnEditar);
        Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detalles.this, Editar.class);
                intent.putExtra("idContactos", id);
                startActivity(intent);
            }
        });



        }
}
