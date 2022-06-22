package PruebasVentaCelular;


import VentaCelular.Ganancia;
import VentaCelular.LecturaArchivo;
import org.junit.*;
import org.junit.internal.runners.statements.ExpectException;

import javax.swing.filechooser.FileSystemView;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GananciaTest {
    Ganancia g = null;
    private static final double DELTA = 1e-15;


    @BeforeClass
    public static void given_AfileDirectory_when_cargarArchivos_then_ok(){
        LecturaArchivo lecturaDeArchivo = new LecturaArchivo();
        int expect = 3;
        int actual = lecturaDeArchivo.cargarCelulares("data\\celulares.txt").size();
        assertEquals(actual, expect);
        System.out.println("Prueba N:. 4");
    }

    @Test (expected = AssertionError.class)
    public void given_AfileDirectorythatDoesNotExist_when_cargarArchivos_then_ok(){
        System.out.println("Prueba N:. 5");
        LecturaArchivo lecturaDeArchivo = new LecturaArchivo();
        int expect = 3;
        int actual = lecturaDeArchivo.cargarCelulares("\\celulares.txt").size();
        assertEquals(actual, expect);
    }

    @Before
    public void setUp(){
        g = new Ganancia();
        System.out.println("Prueba N:. 3");
        System.out.println("\tSetUp");
    }



    @Test
    public void given_two_prices_float_when_calcularGanancia_then_ok() {
        System.out.println("Prueba N:. 1");
        float expected = 50;
        float actual = g.calcularGanancia(250, 200);
        assertEquals(expected, actual, DELTA);

    }
    @After
    public void give_two_prices_float_when_porcentajeGanacia_then_ok(){
        System.out.println("Prueba N:. 2");
        float expected = (float) ((100f)*((50f)/(110f)));
        float actual = g.porcentajeGanancia(160, 110);
        assertEquals(expected, actual, DELTA);
    }

    @Ignore
    public void give_two_pricesAreFloatAndOneOfTheIsZero_when_porcentajeGanacia_then_ok(){
        System.out.println("Prueba N:. 6");
        float expected = (100f)*((50f)/(110f));
        float actual = g.porcentajeGanancia(160, 0);
        assertEquals(expected, actual, 0.0);
    }

    @AfterClass
    public static void given_twoNumbersAndModel_when_generarFicheroGanancia_then_ok(){
        System.out.println("Prueba N:. 7");
        LecturaArchivo lecturaDeArchivo = new LecturaArchivo();
        boolean NoExisteError = lecturaDeArchivo.generarFicheroGanancia("Redmi note 9",
                160,110);
        assertTrue(NoExisteError);
    }

    @Test (timeout = 100)
    public void given_TwoNumberAndModelForCalculateTime_when_generarFicheroGanancia_then_ok(){
        System.out.println("Prueba N:. 8");
        LecturaArchivo lecturaDeArchivo = new LecturaArchivo();
        boolean NoExisteError = lecturaDeArchivo.generarFicheroGanancia("Redmi note 9",
                160,110);
        assertTrue(NoExisteError);
    }

}
