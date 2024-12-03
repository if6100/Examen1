/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.go.ucr.examen1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luise
 */
public class ComisionVentaTest {

    public ComisionVentaTest() {
    }

    @Test
    public void testGettersAndSetters() {
        Rango rango = new Rango(0.0, 1500.0, 0.03);

        // Pruebas para setMenor y getMenor
        rango.setMenor(100.0);
        assertEquals(100.0, rango.getMenor());

        // Pruebas para setMayor y getMayor
        rango.setMayor(2000.0);
        assertEquals(2000.0, rango.getMayor());

        // Pruebas para setValor y getValor
        rango.setValor(0.05);
        assertEquals(0.05, rango.getValor());
    }

    // Pruebas de Caja Negra
    @Test
    public void calcularComision_ClaseValida() {
        // Caso de prueba 1: Clase válida (2000.00)
        Double resultado = ComisionVenta.getCurrentInstance().calcular(2000.00);
        assertEquals(140.00, resultado, 0.01, "La comisión para 2000.00 debería ser 140.00");
    }

    @Test
    public void calcularComision_ValorNegativo() {
        // Caso de prueba 2: Clase inválida (valor negativo)
        Double resultado = ComisionVenta.getCurrentInstance().calcular(-10.00);
        assertEquals(-1.0, resultado, "Debería retornar -1.0 para valores negativos");
    }

    @Test
    public void calcularComision_ValorExcesivo() {
        // Caso de prueba 3: Clase inválida (valor >= 100,000)
        Double resultado = ComisionVenta.getCurrentInstance().calcular(105000.00);
        assertEquals(-1.0, resultado, "Debería retornar -1.0 para valores >= 100,000");
    }

    // Pruebas de Caja Blanca
    @Test
    public void calcularComision_ValorNulo() {
        // Caso 1: Valor nulo
        Double resultado = ComisionVenta.getCurrentInstance().calcular(null);
        assertEquals(-1.0, resultado, "Debería retornar -1.0 para valores nulos");
    }

    @Test
    public void calcularComision_ValorNoCoincideConRangos() {
        // Usar un valor mayor a 100000 para garantizar que esté fuera de rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(200000.00);
        assertEquals(-1.0, resultado, "Debería retornar -1.0 para valores fuera de los rangos definidos");
    }

    @Test
    public void calcularComision_ValorNegativoCajaBlanca() {
        // Caso 2: Valor negativo
        Double resultado = ComisionVenta.getCurrentInstance().calcular(-10.00);
        assertEquals(-1.0, resultado, "Debería retornar -1.0 para valores negativos");
    }

    @Test
    public void calcularComision_FueraDeRango() {
        // Caso 3: Fuera de rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(105000.00);
        assertEquals(-1.0, resultado, "Debería retornar -1.0 para valores fuera de rango");
    }

    @Test
    public void calcularComision_PrimerRango() {
        // Caso 4: Primer rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(1500.00);
        assertEquals(45.00, resultado, 0.01, "La comisión para 1500.00 debería ser 45.00");
    }

    @Test
    public void calcularComision_SegundoRango() {
        // Caso 5: Segundo rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(2000.00);
        assertEquals(140.00, resultado, 0.01, "La comisión para 2000.00 debería ser 140.00");
    }

    @Test
    public void calcularComision_TercerRango() {
        // Caso 6: Tercer rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(6000.00);
        assertEquals(720.00, resultado, 0.01, "La comisión para 6000.00 debería ser 720.00");
    }

    @Test
    public void calcularComision_CuartoRango() {
        // Caso 7: Cuarto rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(20000.00);
        assertEquals(3000.00, resultado, 0.01, "La comisión para 20000.00 debería ser 3000.00");
    }

    @Test
    public void calcularComision_LimiteInferiorPrimerRango() {
        // Caso 8: Valor justo en el límite inferior del primer rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(1500.01);
        assertEquals(105.00, resultado, 0.01, "La comisión para 1500.01 debería ser 105.00");
    }

    @Test
    public void calcularComision_LimiteSegundoRango() {
        // Caso 9: Valor justo en el límite del segundo rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(5000.01);
        assertEquals(600.00, resultado, 0.01, "La comisión para 5000.01 debería ser 600.00");
    }

    @Test
    public void calcularComision_LimiteTercerRango() {
        // Caso 10: Valor justo en el límite del tercer rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(15000.01);
        assertEquals(2250.00, resultado, 0.01, "La comisión para 15000.01 debería ser 2250.00");
    }

    @Test
    public void calcularComision_MontoFueraDeRangos() {
        // Caso 11: Valor no perteneciente a ningún rango definido
        Double resultado = ComisionVenta.getCurrentInstance().calcular(100000.01);
        assertEquals(-1.0, resultado, "Debería retornar -1.0 para valores fuera de los rangos definidos");
    }

    @Test
    public void calcularComision_LimitesExactos() {
        // Caso 12: Límite superior del primer rango
        Double resultado1 = ComisionVenta.getCurrentInstance().calcular(1500.00);
        assertEquals(45.00, resultado1, 0.01, "La comisión para 1500.00 debería ser 45.00");

        // Caso 13: Límite inferior del segundo rango
        Double resultado2 = ComisionVenta.getCurrentInstance().calcular(1500.01);
        assertEquals(105.00, resultado2, 0.01, "La comisión para 1500.01 debería ser 105.00");
    }

    @Test
    public void calcularComision_LimiteSuperiorUltimoRango() {
        // Caso 14: Límite superior del último rango
        Double resultado = ComisionVenta.getCurrentInstance().calcular(100000.00);
        assertEquals(15000.00, resultado, 0.01, "La comisión para 100000.00 debería ser 15000.00");
    }

    @Test
    public void calcularComision_ValorLimiteSuperiorPrimerRango() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(1500.00);
        assertEquals(45.00, resultado, 0.01, "La comisión para el límite superior del primer rango debería ser 45.00");
    }

    @Test
    public void calcularComision_ValorLimiteInferiorSegundoRango() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(1500.01);
        assertEquals(105.00, resultado, 0.01, "La comisión para el límite inferior del segundo rango debería ser 105.00");
    }

}
