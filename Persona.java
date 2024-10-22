package org.example.Modelos;

public class Persona {
   private int codigo;
   private String nombre;
   private String telefono;

   public Persona() {
   }

   public Persona(int codigo, String nombre, String telefono) {
      this.codigo = codigo;
      this.nombre = nombre;
      this.telefono = telefono;
   }

   public int getCodigo() {
      return this.codigo;
   }

   public void setCodigo(int codigo) {
      this.codigo = codigo;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getTelefono() {
      return this.telefono;
   }

   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }

   public String toString() {
      return "Persona{codigo=" + this.codigo + ", nombre='" + this.nombre + "', telefono='" + this.telefono + "'}";
   }
}
