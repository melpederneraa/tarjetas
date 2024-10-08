package org.example.Modelos;

public class Vendedor extends Persona{
    private int legajo;
    public Vendedor() {
    }

    public Vendedor(int legajo,int codigo, String nombre, String telefono) {
        super(codigo, nombre, telefono);
        this.legajo=legajo;
    }

}
