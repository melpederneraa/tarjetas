package org.example.Modelos;

public class Propietario extends Persona{


    public Propietario() {
    }

    public Propietario(int codigo, String nombre, String telefono) {
        super(codigo, nombre, telefono);
    }


    @Override
    public String toString() {
        return "Propietario{" +
                "codigo=" + this.getCodigo() +
                ", nombre='" + this.getNombre() + '\'' +
                ", telefono='" + this.getTelefono() + '\'' +
                '}';
    }
}
