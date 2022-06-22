package VentaCelular;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LecturaArchivo {
    /*
     * El metodo obtenerCuentas devuelve un arraylist de hashmaps en donde el indice representa un hashmap
     * que contiene la informacion del cliente con sus respectivas claves como: nombre, usuario, contrasena
     */
    public ArrayList obtenerCuentas(String direccionDelArchivo) {
        ArrayList<HashMap> informacionCliente = new ArrayList<HashMap>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccionDelArchivo));
            //String txtTemp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                HashMap<String, String> listaDeClientes = new HashMap<String, String>();
                //txtTemp += bfRead + "\n";
                String[] res = bfRead.split("[,]", 0);
                listaDeClientes.put("nombre", res[0]);
                listaDeClientes.put("usuario", res[1]);
                listaDeClientes.put("contrasena", res[2]);
                informacionCliente.add((listaDeClientes));
            }
            //txt = txtTemp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return informacionCliente;
    }

    public ArrayList cargarCelulares(String direccionDelArchivo) {
        ArrayList<HashMap> celulares = new ArrayList<HashMap>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccionDelArchivo));
            //String txtTemp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                HashMap<String, String> informacionCelular = new HashMap<String, String>();
                //txtTemp += bfRead + "\n";
                String[] res = bfRead.split("[,]", 0);
                informacionCelular.put("modelo", res[0]);
                informacionCelular.put("nombreMarca", res[1]);
                informacionCelular.put("codigoImei", res[2]);
                informacionCelular.put("fechaCaducidad", res[3]);
                informacionCelular.put("descripcion", res[4]);
                informacionCelular.put("precio", res[5]);
                informacionCelular.put("precioCompra", res[6]);
                celulares.add((informacionCelular));
            }
            //txt = txtTemp;
        } catch (Exception e) {
            System.out.println("\t El archivo no existe");
        }
        return celulares;
    }


    public ArrayList cargarDatosGanancia(String direccionDelArchivo) {
        ArrayList<HashMap> celularesGanancia = new ArrayList<HashMap>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccionDelArchivo));
            //String txtTemp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                HashMap<String, String> informacionCelularGanancia = new HashMap<String, String>();
                //txtTemp += bfRead + "\n";
                String[] res = bfRead.split("[,]", 0);
                informacionCelularGanancia.put("precioCompra", res[6]);
                celularesGanancia.add((informacionCelularGanancia));
            }
            //txt = txtTemp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return celularesGanancia;
    }
    public boolean generarFicheroGanancia(String modelo, float precioCompraEmpresa, float precioDeVenta) {
        boolean noExisteError = true;
        File fichero = new File("..//ganancias.txt");
        float ganancia = precioDeVenta - precioCompraEmpresa;
        try {
            FileWriter w = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            //wr.write("La ganancia del modelo " + modelo + " es: " + ganancia);
            wr.append("La ganancia del modelo " + modelo+ " es: " + ganancia);
            wr.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return noExisteError;
    }


}
