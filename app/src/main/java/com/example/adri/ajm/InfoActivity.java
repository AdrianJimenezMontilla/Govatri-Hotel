package com.example.adri.ajm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adri.ajm.R;
import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    private TextView nom, tipoInfo, descripcionInfo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle bundle = getIntent().getExtras() ;
        String nombre = bundle.getString("Nombre") ;
        String foto = bundle.getString("Foto") ;
        String descripcion = bundle.getString("Descripcion") ;
        String tipo = bundle.getString("Tipo") ;
        String ubicacion = bundle.getString("Ubicacion") ;
        String telefono = bundle.getString("Telefono") ;


        ImageView imageView = (ImageView) findViewById(R.id.fotoInfo);

        Picasso.with(InfoActivity.this).load(foto).into(imageView);

        nom = findViewById(R.id.texNombre) ;
        nom.setText(nombre) ;

        tipoInfo = findViewById(R.id.textTipo) ;
        tipoInfo.setText("Tipo: " + tipo) ;

        descripcionInfo = findViewById(R.id.textDescripcion) ;
        descripcionInfo.setText("Descripción:  " + descripcion) ;
    }

    public void MasInfo(View view) {
        Bundle bundles = getIntent().getExtras() ;
        String ubicacion = bundles.getString("Ubicacion") ;
        String telefono = bundles.getString("Telefono") ;
        Bundle bundle = new Bundle();
        bundle.putSerializable("ubicacion", ubicacion);
        bundle.putSerializable("telefono", telefono);
        Intent i = new Intent(this, InfoMainActivity.class );
        i.putExtras(bundle) ;
        startActivity(i);
    }
}