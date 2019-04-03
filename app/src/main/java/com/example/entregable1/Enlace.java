package com.example.entregable1;

public class Enlace {
    public String Nombre;
    public String Descripción;
    public  String Url;


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String descripción) {
        Descripción = descripción;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Class getClase() {
        return clase;
    }

    public void setClase(Class clase) {
        this.clase = clase;
    }

    public Enlace(String nombre, String descripción, String url, Class clase) {
        Nombre = nombre;
        Descripción = descripción;
        Url = url;
        this.clase = clase;
    }

    public Class clase;
}
