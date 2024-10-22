package org.example;

import java.util.Iterator;
import java.util.List;
import org.example.Gestores.GestorPropietario;
import org.example.Gestores.GestorTarjeta;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      GestorPropietario gestorP = new GestorPropietario();
      gestorP.cargarPropietariosDesdeArchivo();
      GestorTarjeta gestorT = new GestorTarjeta();
      gestorT.setGestorP(gestorP);
      gestorT.cargarTarjetasDesdeArchivo();
      System.out.println(gestorT.listadoTelefonosSinSaldo());
      List<String> ranking = gestorT.generarRankingSimple();
      System.out.println("Ranking de Vendedores:");
      Iterator var4 = ranking.iterator();

      while(var4.hasNext()) {
         String r = (String)var4.next();
         System.out.println(r);
      }

   }
}
