package org.example.Modelos;

public class Tarjeta {
   private int codigo;
   private Propietario propietario;
   private double saldo;
   private Vendedor vendedor;

   public Tarjeta() {
   }

   public Tarjeta(int codigo, Propietario propietario, double saldo) {
      this.codigo = codigo;
      this.propietario = propietario;
      this.saldo = saldo;
   }

   public int getCodigo() {
      return this.codigo;
   }

   public void setCodigo(int codigo) {
      this.codigo = codigo;
   }

   public Propietario getPropietario() {
      return this.propietario;
   }

   public void setPropietario(Propietario propietario) {
      this.propietario = propietario;
   }

   public double getSaldo() {
      return this.saldo;
   }

   public void setSaldo(double saldo) {
      this.saldo = saldo;
   }

   public String toString() {
      String var10000 = String.valueOf(this.propietario);
      return "Tarjeta: " + var10000 + " Saldo: " + this.saldo;
   }
}
