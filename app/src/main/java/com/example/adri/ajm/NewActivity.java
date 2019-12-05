package com.example.adri.ajm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.adri.ajm.modelos.Hotel;
import com.example.adri.ajm.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewActivity extends AppCompatActivity {

    EditText Nombre, Tipo, descripcion, telefono, ubicacion;
    String foto;
    Button guardar;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        Nombre = findViewById(R.id.newNameRestaurant) ;
        Tipo = findViewById(R.id.newTipeRestaurant);
        descripcion = findViewById(R.id.newdescriptionRestaurant);
        telefono = findViewById(R.id.newtelefonoRestaurant);
        foto = "https://firebasestorage.googleapis.com/v0/b/proyectoandroidstudio-ma-ccd9d.appspot.com/o/posadasEspana.jpg?alt=media&token=eefbe333-17c3-437a-bbca-a70401fbe222";

        guardar = findViewById(R.id.crearhotel);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  nom = Nombre.getText().toString();
                String  tip = Tipo.getText().toString();
                String  des = descripcion.getText().toString();
                String  ubi = "geo:0,0?q=" + Nombre.getText().toString();
                String  tel = telefono.getText().toString();

                String id = databaseReference.push().getKey();

                Hotel rest = new Hotel(nom, tip, des, foto, ubi, tel);

                databaseReference.child("hotels").child(id).setValue(rest);

                Intent intent = new Intent(NewActivity.this, MainActivity.class) ;
                startActivity(intent) ;
            }
        });
    }
}
