package org.example.Modelos;

public class Propietario extends Persona {
   public Propietario() {
   }

   public Propietario(int codigo, String nombre, String telefono) {
      super(codigo, nombre, telefono);
   }

   public String toString() {
      int var10000 = this.getCodigo();
      return "Propietario{codigo=" + var10000 + ", nombre='" + this.getNombre() + "', telefono='" + this.getTelefono() + "'}";
   }
}
