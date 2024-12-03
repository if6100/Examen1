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
 * @author ashle
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

    ComisionVenta comision = ComisionVenta.getCurrentInstance();

    @Test
    public void test1() {
        assertEquals(Double.valueOf(30.0), comision.calcular(1000.00));
    }

    @Test
    public void test2() {
        assertEquals(Double.valueOf(840.0), comision.calcular(7000.00));
    }

    @Test
    public void test3() {
        assertEquals(Double.valueOf(-1.0), comision.calcular(-500.00));
    }

    @Test
    public void testNulo() {
        assertEquals(Double.valueOf(-1.0), comision.calcular(null), "Monto de venta nulo");
    }

    @Test
    public void testFueraDeRango() {
        assertEquals(Double.valueOf(-1.0), comision.calcular(100001.00), "Valor de la venta fuera del rango superior");
    }

    @Test
    public void testRangos() {
        assertEquals(Double.valueOf(45.0), comision.calcular(1500.00), "Borde inferior");
        assertEquals(Double.valueOf(15000.0), comision.calcular(100000.00), "Límite superior");
        assertEquals(Double.valueOf(7500.0), comision.calcular(50000.00), "Intermedio");
    }

    @Test
    public void testSetYGetRango(){
        Rango nuevoRango = new Rango(1000.0, 2000.0, 0.05);
        nuevoRango.setMenor(1200.0);  
        nuevoRango.setMayor(1800.0);  
        nuevoRango.setValor(0.08);    

        assertEquals(1200.0, nuevoRango.getMenor());
        assertEquals(1800.0, nuevoRango.getMayor());
        assertEquals(0.08, nuevoRango.getValor());
    }

}
