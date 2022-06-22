package VentaCelular;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kelvin
 */
public class Garantia {

    private String fechaCaducidad;
    private String descripcion;

    public Garantia(String fechaCaducidad, String descripcion) {
        this.fechaCaducidad = fechaCaducidad;
        this.descripcion = descripcion;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Fecha de caducidad de la garantia = " + fechaCaducidad
                + "\nDescripcion de garantia = " + descripcion;
    }

}
