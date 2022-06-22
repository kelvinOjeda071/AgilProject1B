package VentaCelular;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kelvin
 */
public class Celular {
    private String modelo;
    private String nombreMarca;
    private String codigoImei;
    private Garantia garantia;
    private float precioDeVenta;
    //------------------------
    private float precioDeCompraEmpresa;
    //-----------------------
    private String estado;


    public Celular(String modelo, String nombreMarca, String codigoImei, Garantia garantia, float precio, float precioDeCompraEmpresa) {
        this.modelo = modelo;
        this.nombreMarca = nombreMarca;
        this.codigoImei = codigoImei;
        this.garantia = garantia;
        this.precioDeVenta = precio;
        this.estado = "Disponible";
        this.precioDeCompraEmpresa = precioDeCompraEmpresa;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getCodigoImei() {
        return codigoImei;
    }

    public void setCodigoImei(String codigoImei) {
        this.codigoImei = codigoImei;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public float getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(float precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPrecioDeCompraEmpresa() {
        return precioDeCompraEmpresa;
    }

    @Override
    public String toString() {
        return "Modelo = " + modelo 
                + "\nMarca = " + nombreMarca 
                + "\nCodigo Imei = " + codigoImei
                + "\n" + garantia 
                + "\nPrecio = $" + precioDeVenta
                + "\nEstado = " + estado +"\n";
    }

    
    
    
}
