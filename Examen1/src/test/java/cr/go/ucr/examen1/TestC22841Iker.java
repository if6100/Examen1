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
 * @author Usuario
 */
public class TestC22841Iker {
    
    public TestC22841Iker() {
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
    
    @Test
    public void testMontoSobreMAX() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = 100001.0;
        assertEquals(-1.0, instance.calcular(montoVentaMensual));
    }

    @Test
    public void testMontoTercerRango() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = 10000.0;
        assertEquals(1200.0, instance.calcular(montoVentaMensual));
    }

    @Test
    public void testMontoNull() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = null;
        assertEquals(-1.0, instance.calcular(montoVentaMensual));
    }
    
    @Test
    public void testMontoIncompatible() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaSinRango = 1500.0010;
        assertEquals(-1.0, instance.calcular(montoVentaSinRango));
    }
    
    @Test
    public void testRangoSetear() {
        Rango rango = new Rango(500.0, 700.0, 1.0);
        rango.setMenor(500.0);
        rango.setMayor(700.0);
        rango.setValor(1.0);
        assertEquals(500.0, rango.getMenor());
        assertEquals(700.0, rango.getMayor());
        assertEquals(1.0, rango.getValor());
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ComisionVenta.main(args);
    }
    
}
