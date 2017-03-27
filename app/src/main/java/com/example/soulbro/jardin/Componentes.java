package com.example.soulbro.jardin;

/**
 * Created by SoulBro on 26/03/2017.
 */

public class Componentes {
    private int imagen;
    private String nombre;


    public Componentes(int imagen, String nombre)
    {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }
}
