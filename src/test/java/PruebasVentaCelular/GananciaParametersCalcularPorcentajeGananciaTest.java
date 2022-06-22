package PruebasVentaCelular;

import VentaCelular.Ganancia;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(value = Parameterized.class)
public class GananciaParametersCalcularPorcentajeGananciaTest {
    private static final double DELTA = 1e-15;
    private float precioDeVenta, precioCompraEmpresa, expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters_in_calcularGanancia(){
        List<Object[]> objects = new ArrayList<Object[]>();
        float [] valueExpected = new float [7];
        valueExpected[0]= ((160f-110f)/110f)*100f;
        valueExpected[1]= ((250f-200f)/200f)*100f;
        valueExpected[2]= ((320f-300f)/300f)*100f;
        valueExpected[3]= ((240f-200f)/200f)*100f;
        valueExpected[4]= ((160f-90f)/90f)*100f;
        valueExpected[5]= ((440f-430f)/430f)*100f;
        valueExpected[6]= ((550f-515f)/515f)*100f;
        objects.add(new Object[]{160, 110, valueExpected[0]});
        objects.add(new Object[]{250, 200, valueExpected[1]});
        objects.add(new Object[]{320, 300, valueExpected[2]});
        objects.add(new Object[]{240, 200, valueExpected[3]});
        objects.add(new Object[]{160,  90, valueExpected[4]});
        objects.add(new Object[]{440, 430, valueExpected[5]});
        objects.add(new Object[]{550, 515, valueExpected[6]});
        return objects;
    }
    public GananciaParametersCalcularPorcentajeGananciaTest(float precioDeVenta, float precioCompraEmpresa, float expected){
        this.precioDeVenta = precioDeVenta;
        this.precioCompraEmpresa = precioCompraEmpresa;
        this.expected = expected;
    }

    // Test con parámetros para calcular el porcentaje de ganancia.
    @Test
    public void given_parameters_when_calcularPorcentajeGanancia_then_ok(){
        Ganancia g = new Ganancia();
        float actual = g.porcentajeGanancia(precioDeVenta, precioCompraEmpresa);
        assertEquals(expected, actual, DELTA);
    }
}
