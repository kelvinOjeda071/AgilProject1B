package VentaCelular;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.filechooser.FileSystemView;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Kelvin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //CUANDO EL USUARIO QUIERA INICIAR SESION SE CARGARA LAS CUENTAS EXISTENTES

        Empresa empresa = new Empresa("MERCADOCELL.SA");
        //EXTRACT METHOD
        empresa.cargarCelulares("data\\celulares.txt");
        empresa.cargarCuentas("data\\cuentaClientes.txt");
        empresa.registrarCliente();
        //empresa.iniciarSesionCuentaCliente();
        System.out.println(empresa.mostrarMenuDeIngreso());
        Scanner sc = new Scanner(System.in);
        String opcionMenuCompra;
        opcionMenuCompra = sc.next();
        do {
            switch (opcionMenuCompra) {
                case "1":
                    String modeloDeCelular;
                    int cantidadCelulares;
                    Scanner sc1 = new Scanner(System.in);
                    empresa.mostrarCelulares();
                    System.out.print("Seleccione el celular que desea por su modelo: ");
                    modeloDeCelular = sc1.nextLine();
                    System.out.print("Ingrese la cantidad de telefonos que desee comprar: ");
                    cantidadCelulares = sc1.nextInt();
                    if (empresa.verificarAlComprarCelular(modeloDeCelular, cantidadCelulares)) {
                        empresa.cambiarEstadoNoDisponible(modeloDeCelular, cantidadCelulares);
                        empresa.generarFactura();
                        System.exit(0);

                    } else {
                        System.out.println("El modelo del celular anteriormente ingresado no existe o el stock " +
                                "anteriormente ingresado no se dispone al momento");
                    }
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    System.out.println("La opcion no existe intentelo de nuevo");
                    System.out.println(empresa.mostrarMenuDeIngreso());
                    opcionMenuCompra = sc.next();
            }
        } while (opcionMenuCompra.equals("1"));
    }


}

