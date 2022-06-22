package VentaCelular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ListaMenuDesplegable {
    private ArrayList <MenuDeplegable> listaMenuDesplegable;

    public ListaMenuDesplegable() {
        this.listaMenuDesplegable = new ArrayList<>();
    }

    public void aniadirNuevoElementoDesplegable (MenuDeplegable menu){
        this.listaMenuDesplegable.add(menu);
    }
    // Como todos los elementos estan ingresando de forma ordenada entonces no es necesario ordenarlos

    public int buscarPorModelo(MenuDeplegable modelo){
        Collections.sort(listaMenuDesplegable, new ComparadorPorModeloListaDesplegable());
        return Collections.binarySearch(listaMenuDesplegable, modelo, new ComparadorPorModeloListaDesplegable());
    }

    public boolean estaVacio (){
        return listaMenuDesplegable.isEmpty();
    }

    public MenuDeplegable get(int i){
        return listaMenuDesplegable.get(i);
    }

    public int tamanioDeLaLista(){
        return listaMenuDesplegable.size();
    }

    public void imprimirListaDesplegable(){
        System.out.printf("|%12s|%12s|%18s|%n", "Modelos", "Cantidad", "Precio por unidad");
        for (MenuDeplegable m : listaMenuDesplegable){
            System.out.printf("|%12s|%12d|%18s|%n",m.getModelo(), m.getCantidad(), "$ "+m.getPrecio());
        }
    }

    public void crearArrayListDeModelos(ListaCelulares listaCelulares) {
        listaCelulares.ordenarPorModelo();
        ArrayList<Celular> listaCelularAux = listaCelulares.getListaCelulares();
        Iterator<Celular> iteradorDeCelular = listaCelularAux.iterator();
        MenuDeplegable menuDeplegable;
        String modelo = "";
        int cantidad = 0;
        float precioPorUnidad = 0;
        Celular celularAuxiliar;
        while (iteradorDeCelular.hasNext()) {
            celularAuxiliar = iteradorDeCelular.next();
            if (verificarCelularesDisponibles(celularAuxiliar)) {
                modelo = celularAuxiliar.getModelo();
                precioPorUnidad = celularAuxiliar.getPrecioDeVenta();
                menuDeplegable = new MenuDeplegable(modelo, cantidad, precioPorUnidad);
                if (this.estaVacio()) {
                    this.aniadirNuevoElementoDesplegable(menuDeplegable);
                } else if (this.buscarPorModelo(menuDeplegable) <= -1) {
                    this.aniadirNuevoElementoDesplegable(menuDeplegable);
                }
            }
        }
        listaCelulares.setListaCelulares(listaCelularAux);
        this.delegarLaCantidadPorModelo(listaCelulares);


    }
    public boolean verificarCelularesDisponibles(Celular celular){
        return celular.getEstado().equalsIgnoreCase("Disponible");
    }

    public void delegarLaCantidadPorModelo(ListaCelulares listaCelulares) {
        for (int i = 0; i < listaMenuDesplegable.size(); i++) {
            listaMenuDesplegable.get(i).setCantidad(listaCelulares.contarPorModelo(listaMenuDesplegable.
                    get(i).getModelo()));
        }
    }


    public ArrayList<MenuDeplegable> getListaMenuDesplegable(){
        return this.listaMenuDesplegable;
    }

    public void setListaMenuDesplegable(ArrayList<MenuDeplegable> listaMenuDesplegable) {
        this.listaMenuDesplegable = listaMenuDesplegable;
    }
}
