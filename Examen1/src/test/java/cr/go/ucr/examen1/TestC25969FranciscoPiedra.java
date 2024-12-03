package cr.go.ucr.examen1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestC25969FranciscoPiedra {

    private ComisionVenta instance; 

    public TestC25969FranciscoPiedra() {
    }

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Inicio de pruebas.");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Fin de pruebas.");
    }

    @BeforeEach
    public void setUp() {
        instance = ComisionVenta.getCurrentInstance(); 
    }

    @AfterEach
    public void tearDown() {
        instance = null; 
    }

 
    @Test
    public void testCajaNegraValorNegativo() {
        System.out.println("Prueba de caja negra: Valor negativo");

        Double montoVentaMensual = -10.0;
        Double expResult = -1.0; 
        Double result = instance.calcular(montoVentaMensual);

        assertEquals(expResult, result, "El cálculo con valor negativo no es correcto.");
    }

    
    @Test
    public void testCajaNegraRangoValido() {
    System.out.println("Prueba de caja negra: Rango válido (1500.01 - 5000.00)");

    Double montoVentaMensual = 3000.0; 
    Double expResult = 3000.0 * 0.07; 
    Double result = instance.calcular(montoVentaMensual);

   
    if (montoVentaMensual < 1500.01 || montoVentaMensual > 5000.00) {
        fail("El monto de venta mensual está fuera del rango esperado (1500.01 - 5000.00).");
    }

    assertEquals(expResult, result, "El cálculo para el rango válido no es correcto.");
}

    
    @Test
    public void testCajaNegraMayorAlPermitido() {
        System.out.println("Prueba de caja negra: Valor mayor a $100,000");

        Double montoVentaMensual = 150000.0;
        Double expResult = -1.0; 
        Double result = instance.calcular(montoVentaMensual);

        assertEquals(expResult, result, "El cálculo con valor mayor al permitido no es correcto.");
    }

    // -----------------------------------------------
    // PRUEBAS DE CAJA BLANCA 
   

   
    @Test
    public void testCajaBlancaValorNulo() {
        System.out.println("Prueba de caja blanca: Valor nulo");

        Double montoVentaMensual = null;
        Double expResult = -1.0; // Resultado esperado
        Double result = instance.calcular(montoVentaMensual);

        assertEquals(expResult, result, "El cálculo con valor nulo no es correcto.");
    }


    @Test
    public void testCajaBlancaLimiteInferior() {
        System.out.println("Prueba de caja blanca: Límite inferior (0.0)");

        Double montoVentaMensual = 0.0;
        Double expResult = 0.0 * 0.03; // Comisión esperada
        Double result = instance.calcular(montoVentaMensual);

        assertEquals(expResult, result, "El cálculo en el límite inferior no es correcto.");
    }

   
    @Test
    public void testCajaBlancaLimiteSuperior() {
        System.out.println("Prueba de caja blanca: Límite superior (100,000.0)");

        Double montoVentaMensual = 100000.0;
        Double expResult = 100000.0 * 0.15; // Comisión esperada
        Double result = instance.calcular(montoVentaMensual);

        assertEquals(expResult, result, "El cálculo en el límite superior no es correcto.");
    }

}

