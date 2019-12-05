package com.example.adri.ajm;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adri.ajm.modelos.Hotel;
import com.example.adri.ajm.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.hotelViewHolder>{

    private static Context contexto ;
    private int layout ;
    List<Hotel> hotels;
    private static int posicion ;


    public Adapter(Context contexto, int layout, List<Hotel> hotel) {
        this.contexto = contexto;
        this.layout = layout;
        this.hotels = hotel;
    }


    @NonNull
    @Override
    public hotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext()) ;

        View vista = inflater.inflate(this.layout , viewGroup,false) ;

        hotelViewHolder holder = new hotelViewHolder(vista) ;

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull hotelViewHolder hotelViewHolder, int i) {
        hotelViewHolder.poblar(hotels.get(i));
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public int getPosicion() {
        return posicion;
    }

    public static class hotelViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

        private TextView TextViewNombre;
        private ImageView Foto;

        public hotelViewHolder(@NonNull View itemView) {
            super(itemView);

            TextViewNombre = itemView.findViewById(R.id.nombrehotel);
            Foto = itemView.findViewById(R.id.hotelFoto) ;

            itemView.setOnCreateContextMenuListener(this);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    posicion = getAdapterPosition() ;
                    return false;
                }
            });
        }


        public void poblar(Hotel hotel) {

            TextViewNombre.setText(hotel.getNombre());

            Picasso.with(contexto)
                    .load(hotel.getFoto())
                    .fit()
                    .centerCrop()
                    .into(Foto) ;
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            MenuInflater inflater = ((MainActivity) contexto).getMenuInflater() ;
            inflater.inflate(R.menu.list_hotel_menu2, contextMenu) ;

        }



    }


}
