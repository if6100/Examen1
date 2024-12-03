/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cr.go.ucr.examen1.ComisionVenta;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Kendall
 */
public class TestC19127Kendall {

    @Test
    public void testComisionRangoBajo() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(1000.0);
        assertEquals(30.0, resultado, 0.01); // 3% de 1000
    }

    @Test
    public void testComisionRangoIntermedio() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(7000.0);
        assertEquals(840.0, resultado, 0.01); // 12% de 7000
    }

    @Test
    public void testComisionFueraDeRango() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(150000.0);
        assertEquals(-1.0, resultado, 0.01); // Fuera de rango
    }

    @Test
    public void testComisionNegativa() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(-10.0);
        assertEquals(-1.0, resultado, 0.01); // Valor negativo
    }

    @Test
    public void testComisionMaximaValida() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(100000.0);
        assertEquals(15000.0, resultado, 0.01); // 15% de 100000
    }

    @Test
    public void testComisionConDecimales() {
        // Test con un valor decimal, 7% de 2000.75
        Double resultado = ComisionVenta.getCurrentInstance().calcular(2000.75);
        assertEquals(140.0525, resultado, 0.01);
    }

    @Test
    public void testComisionLimiteRangoBajo() {
        // Justo en el límite inferior del rango, 3% de 1500
        Double resultado = ComisionVenta.getCurrentInstance().calcular(1500.0);
        assertEquals(45.0, resultado, 0.01);
    }

    @Test
    public void testComisionLimiteRangoAlto() {
        // Justo en el límite superior del rango, 12% de 15000
        Double resultado = ComisionVenta.getCurrentInstance().calcular(15000.0);
        assertEquals(1800.0, resultado, 0.01);
    }

    @Test
    public void testComisionMontoCero() {
        // Verificamos que el cálculo para 0.0 sea 0.0
        Double resultado = ComisionVenta.getCurrentInstance().calcular(0.0);
        assertEquals(0.0, resultado, 0.01); // 3% de 0 es 0
    }
    @Test
    public void testComisionRangoMuyAlto() {
        // 15% de 50000, un valor dentro del rango alto
        Double resultado = ComisionVenta.getCurrentInstance().calcular(50000.0);
        assertEquals(7500.0, resultado, 0.01);
    }

    @Test
    public void testComisionMontoNull() {
        // Debería devolver -1.0 para valores null
        Double resultado = ComisionVenta.getCurrentInstance().calcular(null);
        assertEquals(-1.0, resultado, 0.01);
    }

    @Test
    public void testCalculoComision() {
        // Probando valores dentro de los tres rangos establecidos
        assertEquals(30.0, ComisionVenta.getCurrentInstance().calcular(1000.0), 0.01); // Rango bajo
        assertEquals(210.0, ComisionVenta.getCurrentInstance().calcular(3000.0), 0.01); // Rango intermedio
        assertEquals(3750.0, ComisionVenta.getCurrentInstance().calcular(25000.0), 0.01); // Rango alto
    }

    @Test
    public void testComisionSaliendoDelFor() {
        // Comprobando el caso con valores fuera de los rangos de comisión
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(0.1);
        assertEquals(-1.0, resultado, 0.01); // Valor fuera del rango
    }

    @Test
    public void testComisionLimiteSuperior() {
        // Verificando un valor justo por debajo del límite superior, 100000 - 0.01
        Double resultado = ComisionVenta.getCurrentInstance().calcular(99999.99);
        assertEquals(14999.9985, resultado, 0.01); // 15% de 99999.99
    }
   @Test
    public void testComisionDecimalMuyPequeno() {
        // Test con valor muy pequeño
        Double resultado = ComisionVenta.getCurrentInstance().calcular(0.00001);
        
        // Si el valor es demasiado pequeño, debería devolver 0.0
        assertEquals(0.0, resultado, 0.01); // El valor tan pequeño no debería generar comisión
    }
}
