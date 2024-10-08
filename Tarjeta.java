package org.example.Modelos;

public class Tarjeta {
    private int codigo;
    private Propietario propietario;
    private double saldo;

    public Tarjeta() {
    }

    public Tarjeta(int codigo, Propietario propietario, double saldo) {
        this.codigo = codigo;
        this.propietario = propietario;
        this.saldo = saldo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String toString() {
        return  "Tarjeta: "+this.propietario+" Saldo: "+this.saldo;
    }
}
