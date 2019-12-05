package com.example.adri.ajm.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hotel implements Serializable {

    private String IdHotel;

    @Expose
    @SerializedName("Nombre")
    private String Nombre;

    @Expose
    @SerializedName("Tipo")
    private String Tipo;

    @Expose
    @SerializedName("descripcion")
    private String descripcion;

    @Expose
    @SerializedName("foto")
    private String foto;

    @Expose
    @SerializedName("ubicacion")
    private String ubicacion;

    @Expose
    @SerializedName("telefono")
    private String telefono;

    public Hotel() {
    }

    public Hotel(String nombre, String foto) {
        Nombre = nombre;
        this.foto = foto;
    }

    public Hotel(String nombre, String tipo, String descripcion, String foto, String ubicacion, String telefono) {
        Nombre = nombre;
        Tipo = tipo;
        this.descripcion = descripcion;
        this.foto = foto;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }

    public Hotel(String nombre, String tipo, String descripcion, String foto) {
        Nombre = nombre;
        Tipo = tipo;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "hotel{" +
                "Nombre='" + Nombre + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", foto='" + foto + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public String getIdhotel() {
        return IdHotel;
    }

    public void setIdhotel(String idhotel) {
        IdHotel = idhotel;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}