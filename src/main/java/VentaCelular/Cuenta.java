package VentaCelular;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Kelvin
 */
public class Cuenta {
    private String usuario;
    private String contrasenia;

    public Cuenta(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void registrarCompra(){
        // Hacer algo
    }

    public void mostrarMetodoDePago(){
        // Hacer algo
    }

    public void verificarMetodoDePago(){
        // Hacer algo
    }

    @Override
    public String toString() {
        return "Cuenta{" + "usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }


}
