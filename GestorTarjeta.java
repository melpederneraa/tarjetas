package org.example.Gestores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.example.Modelos.Tarjeta;

public class GestorTarjeta {
   private ArrayList<Tarjeta> tarjetas = new ArrayList();
   private GestorPropietario gestorP;

   public GestorTarjeta() {
   }

   public GestorPropietario getGestorP() {
      return this.gestorP;
   }

   public void setGestorP(GestorPropietario gestorP) {
      this.gestorP = gestorP;
   }

   public ArrayList<Tarjeta> getTarjetas() {
      return this.tarjetas;
   }

   public void setTarjetas(ArrayList<Tarjeta> tarjetas) {
      this.tarjetas = tarjetas;
   }

   public void cargarTarjetasDesdeArchivo() {
      try {
         BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\milag\\OneDrive\\Desktop\\example\\archivo.txt"));

         try {
            br.readLine();

            String linea;
            while((linea = br.readLine()) != null) {
               String[] datos = linea.split(",");
               if (datos.length == 3) {
                  String numero = datos[0].trim();
                  int codigoPropietarios = Integer.parseInt(datos[1].trim());
                  double saldo = Double.parseDouble(datos[2].trim());
                  Tarjeta tarjeta = new Tarjeta();
                  tarjeta.setCodigo(Integer.parseInt(numero));
                  tarjeta.setPropietario(this.gestorP.buscarPropietario(codigoPropietarios));
                  tarjeta.setSaldo(saldo);
                  this.tarjetas.add(tarjeta);
               }
            }
         } catch (Throwable var10) {
            try {
               br.close();
            } catch (Throwable var9) {
               var10.addSuppressed(var9);
            }

            throw var10;
         }

         br.close();
      } catch (IOException var11) {
         System.out.println("Error al leer el archivo: " + var11.getMessage());
      }

      System.out.println(this.tarjetas);
   }

   public String listadoTelefonosSinSaldo() {
      String telefono = "";
      Iterator var2 = this.tarjetas.iterator();

      while(var2.hasNext()) {
         Tarjeta t = (Tarjeta)var2.next();
         if (t.getSaldo() <= 0.0 && t.getPropietario() != null) {
            telefono = telefono + t.getPropietario().getTelefono() + "\n";
         }
      }

      return telefono;
   }

   public List<String> generarRankingSimple() {
      List<String> ranking = new ArrayList();
      List<String> propietariosYaContados = new ArrayList();
      Iterator var3 = this.tarjetas.iterator();

      while(var3.hasNext()) {
         Tarjeta tarjeta = (Tarjeta)var3.next();
         if (tarjeta.getSaldo() > 1000.0) {
            String propietarioNombre = tarjeta.getPropietario().getNombre();
            int var10000 = tarjeta.getPropietario().getCodigo();
            String rankingEntry = "Propietario ID: " + var10000 + " | Tarjeta ID: " + tarjeta.getCodigo() + " | Saldo: $" + tarjeta.getSaldo();
            if (!propietariosYaContados.contains(propietarioNombre)) {
               ranking.add(rankingEntry);
               propietariosYaContados.add(propietarioNombre);
            }
         }
      }

      return ranking;
   }
}
