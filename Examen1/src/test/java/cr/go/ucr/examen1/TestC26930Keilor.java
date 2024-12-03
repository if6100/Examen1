package cr.go.ucr.examen1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Romero
 */
public class TestC26930Keilor {

    public TestC26930Keilor() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    //(10 puntos) Realizar las pruebas de caja negra identificadas en el punto anterior utilizando Junit Test
    //como fue visto en clases.  Genere las evidencias de la ejecución de las pruebas y las entrega, así como el 
    //código fuente utilizado. *Test Caja Negra
    
    //Prueba con un valor de venta mensual negativo.
    @Test
    public void testMontoNegativo() {
        System.out.println("Testing...");
        Double montoVentaMensual = -1111.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = -1.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }

    //Prueba con un valor de venta mensual superior al máximo permitido (100000.0).
    @Test
    public void testMontoSuperiorAlMaximo() {
        System.out.println("Testing...");
        Double montoVentaMensual = 111111.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = -1.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }

    //Prueba con un valor de venta mensual dentro del rango [5000.01, 15000.00].
    @Test
    public void testMontoEnTercerRango() {
        System.out.println("Testing...");
        Double montoVentaMensual = 5900.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = 708.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }

    //(10 puntos) Realizar las pruebas de caja blanca (recorrer el código con una cobertura del 100%)
    //utilizando Junit Test como fue visto en clases que permita probar todo el código.  Genere 
    //las evidencias de la ejecución de las pruebas y las entrega, así como el código fuente utilizado. *Caja Blanca
    //Prueba con un valor de venta mensual dentro del rango [5000.01, 15000.00].
    @Test
    public void testMontoCercanoAlLimiteSuperior() {
        System.out.println("Testing...");
        Double montoVentaMensual = 14990.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = 1798.8;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }

    //Prueba que verifica que el método getCurrentInstance devuelva siempre la misma instancia de la clase ComisionVenta.
    @Test
    public void testGetInstanciaUnica() {
        System.out.println("Testing...");
        ComisionVenta expResult = ComisionVenta.getCurrentInstance();
        ComisionVenta result = ComisionVenta.getCurrentInstance();
        assertEquals(expResult, result);
    }

    //Prueba con un monto de venta mensual que no pertenece a ningún rango definido.
    @Test
    public void testMontoVentaFueraDeTodosLosRangos() {
        System.out.println("Testing...");
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaSinRango = 1500.005;
        assertEquals(-1.0, instance.calcular(montoVentaSinRango));
    }

    //Prueba con un valor de venta mensual alto dentro del rango superior [15000.00, 100000.00]
    @Test
    public void testMontoEnUltimoRango() {
        System.out.println("Testing...");
        Double montoVentaMensual = 99000.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = 14850.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }

    //Prueba con un valor de venta mensual en el primer rango [0.0, 1500.00]. 
    @Test
    public void testMontoEnPrimerRango() {
        System.out.println("Testing...");
        Double montoVentaMensual = 111.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = 3.33;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }

    //Prueba que ejecuta el método main sin errores. Se utiliza principalmente 
    //para comprobar que no hay excepciones en el flujo principal.
    @Test
    public void testMain() {
        System.out.println("Testing...");
        String[] args = null;
        ComisionVenta.main(args);
    }
}
