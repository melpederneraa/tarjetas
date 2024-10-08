package org.example.Gestores;

import org.example.Modelos.Tarjeta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorTarjeta {
    private ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    private GestorPropietario gestorP;

    public GestorPropietario getGestorP() {
        return gestorP;
    }

    public void setGestorP(GestorPropietario gestorP) {
        this.gestorP = gestorP;
    }

    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public void cargarTarjetasDesdeArchivo(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Documents\\UTN-FRVM\\Paradigma\\CodigoC2\\TarjetaGamer\\src\\main\\java\\org\\example\\archivo.txt"))) {
            String linea;
            br.readLine();//linea de titulos, si la tengo, de esta manera la leo pero no la utilizo
            while ((linea = br.readLine()) != null) {//mientras haya una linea mas en el archivo
                String[] datos = linea.split(","); //tomo los datos

                if (datos.length == 3) {
                    String numero = datos[0].trim();
                    int codigoPropietarios = Integer.parseInt(datos[1].trim());
                    double saldo = Double.parseDouble(datos[2].trim());

                    Tarjeta tarjeta = new Tarjeta();
                    tarjeta.setCodigo(Integer.parseInt(numero));
                    tarjeta.setPropietario(gestorP.buscarPropietario(codigoPropietarios));
                    tarjeta.setSaldo(saldo);
                    tarjetas.add(tarjeta);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println(tarjetas);
    }

    public String listadoTelefonosSinSaldo(){
        String telefono="";
        for (Tarjeta t: tarjetas){
            if(t.getSaldo()<=0){
                telefono = telefono + t.getPropietario().getTelefono();
            }
        }
        return telefono;
    }

}
