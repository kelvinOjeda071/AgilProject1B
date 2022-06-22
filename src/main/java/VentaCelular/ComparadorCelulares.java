package VentaCelular;

import java.util.Comparator;

public class ComparadorCelulares implements Comparator<Celular> {
   // Método que permite ordenar los celualres acorde con su modelo
    @Override
    public int compare(Celular o1, Celular o2) {
        return (o1.getModelo().compareTo(o2.getModelo()));
    }
}
