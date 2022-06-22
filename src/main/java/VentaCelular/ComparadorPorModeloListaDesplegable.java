package VentaCelular;

import java.util.Comparator;

public class ComparadorPorModeloListaDesplegable implements Comparator<MenuDeplegable> {

    // Método que permite ordenar el menú desplegable acorde con el modelo referenciado dentro del mismo
    @Override
    public int compare(MenuDeplegable o1, MenuDeplegable o2) {
        return (o1.getModelo().compareTo(o2.getModelo()));
    }
}
