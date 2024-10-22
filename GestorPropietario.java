package org.example.Gestores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.example.Modelos.Propietario;

public class GestorPropietario {
   private ArrayList<Propietario> propietarios = new ArrayList();

   public GestorPropietario() {
   }

   public ArrayList<Propietario> getPropietarios() {
      return this.propietarios;
   }

   public void setPropietarios(ArrayList<Propietario> propietarios) {
      this.propietarios = propietarios;
   }

   public void cargarPropietariosDesdeArchivo() {
      try {
         BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\milag\\OneDrive\\Desktop\\example\\propietarios.txt"));

         try {
            br.readLine();

            String linea;
            while((linea = br.readLine()) != null) {
               String[] datos = linea.split(",");
               if (datos.length == 3) {
                  String numero = datos[0].trim();
                  String titular = datos[1].trim();
                  String telefono = datos[2].trim();
                  Propietario prop = new Propietario(Integer.parseInt(numero), titular, telefono);
                  this.propietarios.add(prop);
               }
            }
         } catch (Throwable var9) {
            try {
               br.close();
            } catch (Throwable var8) {
               var9.addSuppressed(var8);
            }

            throw var9;
         }

         br.close();
      } catch (IOException var10) {
         System.out.println("Error al leer el archivo: " + var10.getMessage());
      }

      System.out.println(this.propietarios);
   }

   public Propietario buscarPropietario(int codigo) {
      Iterator var2 = this.propietarios.iterator();

      Propietario p;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         p = (Propietario)var2.next();
      } while(p.getCodigo() != codigo);

      return p;
   }
}
