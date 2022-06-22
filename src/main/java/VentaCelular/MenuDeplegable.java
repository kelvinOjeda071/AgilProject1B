package VentaCelular;

public class MenuDeplegable {
    private String modelo;
    private int cantidad;
    private float precio;

    public MenuDeplegable() {
        this.modelo = "";
        this.cantidad = 0;
        this.precio = 0;
    }

    public MenuDeplegable(String modelo, int cantidad, float precio) {
        this.modelo = modelo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ListaDesplegableCelulares" + '\'' +
                "modelo='" + modelo + '\'' +
                "cantidad=" + cantidad;
    }
}
