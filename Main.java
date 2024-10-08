package org.example;

import org.example.Gestores.GestorPropietario;
import org.example.Gestores.GestorTarjeta;
import org.example.Modelos.Tarjeta;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GestorPropietario gestorP=new GestorPropietario();
        gestorP.cargarPropietariosDesdeArchivo();

        GestorTarjeta gestorT = new GestorTarjeta();
        gestorT.setGestorP(gestorP);
        gestorT.cargarTarjetasDesdeArchivo();

        System.out.println(gestorT.listadoTelefonosSinSaldo());


      // Tarjeta tarjeta1=new Tarjeta(1,"Sole",1500);
      // System.out.println(tarjeta1);
    }
}