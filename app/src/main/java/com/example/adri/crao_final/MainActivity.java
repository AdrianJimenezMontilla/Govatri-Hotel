package com.example.adri.crao_final;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.adri.crao_final.modelos.Hotel;
import com.example.adri.crao_final.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Hotel> hotels;
    Adapter adapter;


    private DataSnapshot dataSnapshot;
    private LinearLayoutManager manager ;

    private FirebaseDatabase database ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rv =(RecyclerView) findViewById(R.id.recycler);

        rv.setLayoutManager(new LinearLayoutManager(this));

        hotels = new ArrayList<Hotel>();

        DatabaseReference database2;
       database = FirebaseDatabase.getInstance();

        adapter = new Adapter(this ,R.layout.row_recycler, hotels) ;

        rv.setAdapter(adapter);

        manager = new LinearLayoutManager(this) ;
        rv.setLayoutManager(manager) ;

        database.getReference("hotels").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                hotels.clear();
                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren()){

                    Hotel hotel = new Hotel();

                    hotel = snapshot.getValue(Hotel.class);
                    hotel.setIdhotel(snapshot.getKey()) ;

                    hotels.add(hotel);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Obtenemos el inflador para inflar el menú
        getMenuInflater().inflate(R.menu.list_hotel_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.Infohotel:

                String nombre = hotels.get(adapter.getPosicion()).getNombre();
                String foto = hotels.get(adapter.getPosicion()).getFoto();
                String descripcion = hotels.get(adapter.getPosicion()).getDescripcion();
                String tipo = hotels.get(adapter.getPosicion()).getTipo();
                String ubicacion = hotels.get(adapter.getPosicion()).getUbicacion();
                String telefono = hotels.get(adapter.getPosicion()).getTelefono();


                Bundle bundle = new Bundle();
                bundle.putSerializable("Nombre", nombre);
                bundle.putSerializable("Foto", foto);
                bundle.putSerializable("Descripcion", descripcion);
                bundle.putSerializable("Tipo", tipo);
                bundle.putSerializable("Ubicacion", ubicacion);
                bundle.putSerializable("Telefono", telefono);

                Intent intent3 = new Intent(MainActivity.this, InfoActivity.class) ;
                intent3.putExtras(bundle) ;
                startActivity(intent3) ;


                break ;

            case R.id.Borrarhotel:

                database.getReference("hotels/" + hotels.get(adapter.getPosicion()).getIdhotel()).removeValue() ;

                break ;

            default :
                return super.onOptionsItemSelected(item);
        }


        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Comprobar qué opción ha elegido el usuario
        switch(item.getItemId()) {
            case R.id.Newhotel:
                Intent intent = new Intent(MainActivity.this, NewActivity.class) ;
                startActivity(intent) ;

                break ;

            case R.id.listhotelExit:
                Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show();
                // finish();
                Intent intent2 = new Intent(MainActivity.this, LoginActivity.class) ;
                startActivity(intent2) ;
                break ;

            default :
                return super.onOptionsItemSelected(item);
        }

        return true ;
    }


    @Override
    public void onBackPressed(){}
}
