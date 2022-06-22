package VentaCelular;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Kelvin
 */
public class Empresa {
    private String nombre;
    private ListaCelulares listaCelularesEmpresa;
    //EMPRESA TIENE CLIENTES Y LOS CLIENTES TIENEN CUENTAS
    private ArrayList<Cliente> listaDeClientes;
    //Celulares comprados
    ArrayList<Celular> listaCelularesComprados = new ArrayList<>();


    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaCelularesEmpresa = new ListaCelulares();
        this.listaDeClientes = new ArrayList<>();
    }

    public void mostrarCelulares() {
        String salida = "";
        salida += "Bienvenido a la empresa " + this.nombre
                + "\nA continuacion te ofrecemos nuestra lista de telefonos "
                + "celulares";

        System.out.println(salida);
        listaCelularesEmpresa.crearListaMenuDesplegable();
        listaCelularesEmpresa.imprimirPorConsolaElementosListaDeMenu();
    }

    // Verifica la existencia del modelo del celular una vez que el usuario ingresa el modelo de celular a comprar
    public boolean verificarExistenciaCelular(String modelo) {
        return listaCelularesEmpresa.verificarExistenciaCelularesMenuDesplegable(modelo);
    }

    // Verifica que exista el suficiente stock como para vender un conjunto de celulares
    public boolean verificarDisponibilidadCelular(int cantidad, String modelo) {
        return listaCelularesEmpresa.verificarDisponibilidadMenuDesplegable(cantidad, modelo);
    }

    // Se cambia el estado de los celulares una vez que los mismos se los ha fichado como vendidos
    public void cambiarEstadoNoDisponible(String modelo, int cantidad) {

        int cantidadIndisponible = 0;
        for (int i = 0; i < listaCelularesEmpresa.tamanioLista(); i++) {
            if (listaCelularesEmpresa.get(i).getModelo().equals(modelo) && cantidadIndisponible < cantidad) {
                this.listaCelularesEmpresa.get(i).setEstado("No disponible");
                cantidadIndisponible++;
                listaCelularesComprados.add(listaCelularesEmpresa.get(i));
            }
        }
    }

    // Se emite la factura acorde con los parametros de la clase factura.
    public void generarFactura() {
        String salida = "";
        salida += ("Se ha realizado la compra con exito");
        salida += ("\nAcontinuacion se presenta su factura");
        System.out.println(salida);
        Factura factura = new Factura("1", "Compra de celulares ", listaCelularesComprados);
        salida += factura.emitirFactura();
        System.out.println(salida);
    }

    public void registrarCliente() {
        //REFACTORING : MOVE METHOD
        Cliente datosCliente = obtenerDatosUsuario();
        //REFACTORING: MOVE METHOD
        registrarUsuario(new Cliente(datosCliente.getNombre(), datosCliente.getCuenta()));
    }

    private boolean verificarCuentaCliente(Cuenta nuevaCuenta) {
        boolean usuarioEncontrado = false;
        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            if (this.listaDeClientes.get(i).getCuenta().getUsuario().equals(nuevaCuenta.getUsuario())) {
                usuarioEncontrado = true;
                break;
            }
        }
        return usuarioEncontrado;
    }


    public void iniciarSesionCuentaCliente(String usuario, String contrasena) {
        //SE DEBERIA ENVIAR EL ARCHIVO CON LAS CUENTAS PARA VERIFICAR SUS CREDENCIALES

        /*
         * Pueden existir 3 tipos de excepciones:
         * 1.- Cuando el usuario es el mismo
         * 2.- Cuando la contrasena es incorrecta
         * 3.- Cuando no tiene una cuenta registrada
         */
        Cuenta cuentaCliente = new Cuenta(usuario, contrasena);

        //Caso cuando tiene el mismo uuario
        if (verificarCuentaCliente(cuentaCliente)) {
            System.out.println("ESTE USUARIO YA EXISTE, COLOCAR OTRO USUARIO!!");
            registrarCliente();
        }
    }

    public void cargarCuentas(String direccionDelArchivo) {
        //"direccion: C:\\Users\\gianc\\Desktop\\cuentaClientes.txt"
        LecturaArchivo archivo = new LecturaArchivo();
        ArrayList cuentas = archivo.obtenerCuentas(direccionDelArchivo);
        // Obtiene cada hashmap y de cada uno obtiene sus 3 claves
        for (int i = 0; i < cuentas.size(); i++) {
            HashMap mp = (HashMap) cuentas.get(i);
            String nombre = (String) mp.get("nombre");
            String usuario = (String) mp.get("usuario");
            String contrasena = (String) mp.get("contrasena");
            //Se coloca en el arraylist de clientes de la empresa ya existentes
            Cuenta cuentaCliente = new Cuenta(usuario, contrasena);
            Cliente cliente = new Cliente(nombre, cuentaCliente);
            this.listaDeClientes.add(cliente);
        }
    }

    //Menú que permite visualizar las opciones de compra hacia el comprador
    public String mostrarMenuDeIngreso() {
        return "\n\nSeleccione una de las siguientes opciones: "
                + "\n1. Comprar celular"
                + "\n2. Salir"
                + "\nIngrese la opcion: ";
    }

    // Permite realizar las dos verificaciones al momento de realizar una compra de celulares:
    // - Existencia del modelo a comprar
    // - Existencia de suficiente stock como para vender un conjunto de celulares

    public boolean verificarAlComprarCelular(String modelo, int cantidad) {
        final boolean existeCelular = this.verificarExistenciaCelular(modelo);
        final boolean estaDisponibleCelular = this.verificarDisponibilidadCelular(cantidad, modelo);
        return (existeCelular && estaDisponibleCelular);
    }

    //REFACTORING: EXTRACT METHOD
    private void registrarUsuario(Cliente nuevoCliente) {
        //TODO: Verificar que no exista una cuenta con el mismo usuario
        //REFACTORING: INTRODUCE EXPLAINING VARIABLE
        boolean existeCliente = verificarCuentaCliente(nuevoCliente.getCuenta());
        if (!existeCliente) {
            this.listaDeClientes.add(nuevoCliente);
            System.out.println("USUARIO CREADO CON EXITO!!");
        } else {
            System.out.println("ESTE USUARIO YA EXISTE CREAR OTRO USUARIO!!!");
            registrarCliente();
        }
        //System.out.println(listaDeClientes);
    }

    private Cliente obtenerDatosUsuario() {
        Scanner entradaDeDatos = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombreCliente = entradaDeDatos.next();
        System.out.print("Cree un usuario: ");
        String nombreDeUsuario = entradaDeDatos.next();
        System.out.print("Cree una contrasena: ");
        String contrasena = entradaDeDatos.next();
        return new Cliente(nombreCliente, new Cuenta(nombreDeUsuario, contrasena));
    }

    public void cargarCelulares(String direccionArchivo) {
        //"direccion: C:\\Users\\gianc\\Desktop\\celulares.txt"
        LecturaArchivo archivo = new LecturaArchivo();
        ArrayList celulares = archivo.cargarCelulares(direccionArchivo);
        // Obtiene cada hashmap y de cada uno obtiene sus 3 claves
        for (int i = 0; i < celulares.size(); i++) {
            HashMap mp = (HashMap) celulares.get(i);
            String modelo = (String) mp.get("modelo");
            String nombreMarca = (String) mp.get("nombreMarca");
            String codigoImei = (String) mp.get("codigoImei");
            String fechaCaducidad = (String) mp.get("fechaCaducidad");
            String descripcion = (String) mp.get("descripcion");
            float precio = Float.parseFloat((String) mp.get("precio"));
            float precioCompraEmp = Float.parseFloat((String) mp.get("precioCompra"));
            //Se coloca en el arraylist de celulares de la empresa ya existentes
            Garantia garantia = new Garantia(fechaCaducidad, descripcion);
            Celular c = new Celular(modelo, nombreMarca, codigoImei, garantia, precio, precioCompraEmp);
            this.listaCelularesEmpresa.aniadirCelular(c);
        }
    }


}
