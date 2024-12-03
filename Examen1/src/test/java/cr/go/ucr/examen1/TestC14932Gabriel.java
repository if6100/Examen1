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
 * @author Gabriel
 */
public class TestC14932Gabriel {
    

    @Test
    public void testCalcularCajaNegra1() {
        System.out.println("calcular");
        Double montoVentaMensual = -2000.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = -1.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcularCajaNegra2() {
        System.out.println("calcular");
        Double montoVentaMensual = 110000.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = -1.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcularCajaNegra3() {
        System.out.println("calcular");
        Double montoVentaMensual = 6700.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = 804.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcularCajaBlanca1() {
        System.out.println("calcular");
        Double montoVentaMensual = 14000.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = 1680.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcularCajaBlanca2() {
        System.out.println("calcular");
        Double montoVentaMensual = 95000.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = 14250.0;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcularCajaBlanca3() {
        System.out.println("calcular");
        Double montoVentaMensual = 750.0;
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double expResult = 22.5;
        Double result = instance.calcular(montoVentaMensual);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCurrentInstance() {
        System.out.println("getCurrentInstance");
        ComisionVenta expResult = ComisionVenta.getCurrentInstance();
        ComisionVenta result = ComisionVenta.getCurrentInstance();
        assertEquals(expResult, result);
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ComisionVenta.main(args);
    }
    
    @Test
    public void testSetYGetRango() {
        Rango rango = new Rango(750.0, 800.0, 0.10);
        rango.setMenor(725.0);
        rango.setMayor(775.0);
        rango.setValor(0.20);
    }
    
    @Test
    public void testMontoVentaSinRangoEstablecido() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaSinRango = 1500.005; 
        assertEquals(-1.0, instance.calcular(montoVentaSinRango));
    }
}