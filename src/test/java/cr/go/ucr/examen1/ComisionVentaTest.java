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
 * @author DQ
 */
public class ComisionVentaTest {

    public ComisionVentaTest() {
    }
    private ComisionVenta comisionVenta;

    @BeforeEach
    public void setUp() {
        comisionVenta = ComisionVenta.getCurrentInstance();
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ComisionVenta.main(args);
    }

    /**
     *COMISIONVENTA
     */
    @Test
    public void testComisionVentaBaja() {
        Double montoVenta = 1000.0;
        Double comision = comisionVenta.calcular(montoVenta);
        assertEquals(30.0, comision, "La comisión debe ser el 3% de 1000");
    }

    @Test
    public void testComisionVentaMedia() {
        double montoVenta = 3000.0;
        double comisionEsperada = montoVenta * 0.07;
        double resultado = comisionVenta.calcular(montoVenta);
        assertEquals(comisionEsperada, resultado, "La comisión debe ser el 7% de 3000");
    }

    @Test
    public void testComisionVentaNegativa() {
        Double montoVenta = -100.0;
        Double comision = comisionVenta.calcular(montoVenta);
        assertEquals(-1.0, comision, "La comisión para un monto negativo debe ser -1");
    }

    @Test
    public void testComisionVentaAlta() {
        Double montoVenta = 10000.0;
        Double comisionEsperada = montoVenta * 0.12;
        Double resultado = comisionVenta.calcular(montoVenta);
        assertEquals(comisionEsperada, resultado, "La comisión debe ser el 12% de 10000");
    }

    @Test
    public void testComisionVentaExcedeMaximo() {
        Double montoVenta = 120000.0;
        Double comision = comisionVenta.calcular(montoVenta);
        assertEquals(-1.0, comision, "La comisión para un monto mayor a 100000 debe ser -1");
    }

    /**
     *RANGO
     */
    @Test
    public void testRangoValoresValidos() {
        Rango rango = new Rango(0.0, 1500.0, 0.03);
        assertEquals(0.0, rango.getMenor(), "El menor del rango debe ser 0.0");
        assertEquals(1500.0, rango.getMayor(), "El mayor del rango debe ser 1500.0");
        assertEquals(0.03, rango.getValor(), "El valor del rango debe ser 0.03");
    }

    @Test
    public void testRangoModificarValores() {
        Rango rango = new Rango(0.0, 1500.0, 0.03);
        rango.setMenor(100.0);
        rango.setMayor(2000.0);
        rango.setValor(0.05);

        assertEquals(100.0, rango.getMenor(), "El menor del rango debe ser 100.0");
        assertEquals(2000.0, rango.getMayor(), "El mayor del rango debe ser 2000.0");
        assertEquals(0.05, rango.getValor(), "El valor del rango debe ser 0.05");
    }

    @Test
    public void testRangoInvalido() {
        Rango rango = new Rango(-10.0, -5.0, 0.03);
        assertTrue(rango.getMenor() < 0, "El rango puede tener valores negativos como entrada.");
        assertTrue(rango.getMayor() < 0, "El rango puede tener valores negativos como entrada.");
    }

    @Test
    public void testRangoValorCero() {
        Rango rango = new Rango(0.0, 0.0, 0.0);
        assertEquals(0.0, rango.getMenor(), "El menor debe permitir cero como valor");
        assertEquals(0.0, rango.getMayor(), "El mayor debe permitir cero como valor");
        assertEquals(0.0, rango.getValor(), "El valor debe permitir cero como comisión");
    }
}
