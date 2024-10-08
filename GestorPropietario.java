package org.example.Gestores;

import org.example.Modelos.Propietario;
import org.example.Modelos.Tarjeta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorPropietario {
    private ArrayList<Propietario> propietarios = new ArrayList<>();

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(ArrayList<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public void cargarPropietariosDesdeArchivo(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Documents\\UTN-FRVM\\Paradigma\\CodigoC2\\TarjetaGamer\\src\\main\\java\\org\\example\\propietarios.txt"))) {
            String linea;
            br.readLine();//linea de titulos, si la tengo, de esta manera la leo pero no la utilizo
            while ((linea = br.readLine()) != null) {//mientras haya una linea mas en el archivo
                String[] datos = linea.split(","); //tomo los datos

                if (datos.length == 3) {
                    String numero = datos[0].trim();
                    String titular = datos[1].trim();
                    String telefono = datos[2].trim();

                    Propietario prop=new Propietario(Integer.parseInt(numero),titular,telefono);
                    propietarios.add(prop);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println(propietarios);
    }

    public Propietario buscarPropietario(int codigo){
        for (Propietario p: propietarios){
            if(p.getCodigo()==codigo){
                return p;
            }
        }
        return null;
    }

}
