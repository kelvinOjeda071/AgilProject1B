package VentaCelular;

public class CompraCelularExecute {
    public static void main(String[] args) {
        Empresa e = new Empresa("Empresa de prueba");
        /*Se cargan los datos asociados a los telefonos con los que se encuentra a disposición*/
        e.cargarCelulares("..//data//celulares.txt");
        /*Se cargan las cuentas ingresadas con anterioridad*/
        e.cargarCuentas("..//data//cuentaClientes.txt");
        /*Se muestran los celulares disponibles dentro del stock*/
        e.mostrarCelulares();
        /*Se cambia el estado del teléfono a no disponible*/
        e.cambiarEstadoNoDisponible("Redmi note 8", 1);
        /*Se genera la respectiva factura asociada a la venta del teléfono*/
        e.generarFactura();

    }

}
