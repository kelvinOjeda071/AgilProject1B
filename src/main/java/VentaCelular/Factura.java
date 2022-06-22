package VentaCelular;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Kelvin
 */
public class Factura {
    public Ganancia g;
    private String identificador;
    private String detalleFactura;
    private double total = 0;
    private final int iva = 12;
    private String fecha;

    protected ArrayList<Celular> listaCelulares;

    public Factura(String identificador, String detalleFactura, ArrayList<Celular> listaCelular) {
        this.identificador = identificador;
        this.detalleFactura = detalleFactura;
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.fecha = format.format(today);
        this.listaCelulares = listaCelular;
    }

    public void agregarListaCelulares(Celular celular) {
        this.listaCelulares.add(celular);
    }

    public double calcularPrecioTotal() {
        for (int i = 0; i < this.listaCelulares.size(); i++) {
            this.total += this.listaCelulares.get(i).getPrecioDeVenta();
        }
        return this.total;
    }

    public double calcularPrecioTotalConIva() {
        return this.total + ((this.total * this.iva) / 100);
    }


    public String emitirFactura() {
        String salida = "";
        salida += "Factura N:. " + identificador + "\n"
                + "Fecha de compra = " + fecha + "\n";
        for (int i = 0; i < this.listaCelulares.size(); i++) {
            salida += this.listaCelulares.get(i).getModelo() + "  ";
            salida += this.listaCelulares.get(i).getPrecioDeVenta() + "   \n";
        }
        salida += "Sumatoria de precios = $" + calcularPrecioTotal()
                + "\nIva = " + iva + " %"
                + "\nPrecio final = $" + calcularPrecioTotalConIva();
        //Se tiene que generar una ganancia del celular vendido
        generarFicheroGanancia(this.listaCelulares);
        return salida;

    }

    public void generarFicheroGanancia(ArrayList<Celular> celularesVendidos) {
        File fichero = new File("..\\data\\ganancias.txt");
        try {
            FileWriter w = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            //wr.write("La ganancia del modelo " + modelo + " es: " + ganancia);
            obtenerDatosGanancias(celularesVendidos, wr);
            wr.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void obtenerDatosGanancias(ArrayList<Celular> celularesVendidos, PrintWriter wr) {
        for (Celular celularVendido : celularesVendidos) {
            float ganancia = calcularGanancia(celularVendido);
            wr.append("La ganancia del modelo " + celularVendido.getModelo() + " es: " + ganancia + "\n");
        }
    }

    private float calcularGanancia(Celular celularVendido) {
        float precioCompraEmpresa = celularVendido.getPrecioDeCompraEmpresa();
        float precioDeVenta = celularVendido.getPrecioDeVenta();
        return precioDeVenta - precioCompraEmpresa;
    }


}
