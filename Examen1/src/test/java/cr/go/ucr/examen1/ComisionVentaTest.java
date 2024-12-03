/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.go.ucr.examen1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author urtec
 */
public class ComisionVentaTest {

    public ComisionVentaTest() {
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

    /**
     * Prueba de caja negra para un monto dentro del rango válido.
     */
    @Test
    public void testCalcularDentroDelRango() {
        System.out.println("calcularDentroDelRango");
        Double montoVentaMensual = 2500.00;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = 175.00;
        Double result = instance.calcular(montoVentaMensual);
        double delta = 0.0001;
        assertEquals(expResult, result, delta);
    }

    /**
     * Prueba de caja negra para un monto fuera del rango superior.
     */
    @Test
    public void testCalcularFueraDelRangoSuperior() {
        System.out.println("calcularFueraDelRangoSuperior");
        Double montoVentaMensual = 110000.00;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = -1.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }

    /**
     * Prueba de caja negra para un monto negativo fuera del rango.
     */
    @Test
    public void testCalcularMontoNegativo() {
        System.out.println("calcularMontoNegativo");
        Double montoVentaMensual = -20.00;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = -1.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }

    /**
     * Prueba de caja blanca con cobertura total.
     */
    @Test
    public void testCalcularCoberturaCompleta() {
        System.out.println("calcularCoberturaCompleta");
        ComisionVenta instance = ComisionVenta.getCurrentInstance();

        double delta = 0.001;
        assertEquals(30.0, instance.calcular(1000.00), delta);
        assertEquals(245.00, instance.calcular(3500.00), delta);
        assertEquals(-1.0, instance.calcular(-75.00), delta);
        assertEquals(-1.0, instance.calcular(120000.0), delta);
        assertEquals(720.0, instance.calcular(6000.00), delta);
        assertEquals(3000.0, instance.calcular(20000.00), delta);
    }

}
