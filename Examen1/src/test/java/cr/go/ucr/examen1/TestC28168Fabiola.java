package cr.go.ucr.examen1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestC28168Fabiola {

    public TestC28168Fabiola() {
    }

    @Test
    public void testMontoVentaMensualNegativo() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = -1.0;
        assertEquals(-1.0, instance.calcular(montoVentaMensual));
    }

    @Test
    public void testMontoVentaPrimeraClase() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = 3000.0;
        assertEquals(210.00000000000003, instance.calcular(montoVentaMensual));
    }

    @Test
    public void testMontoVentaTope() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = 100001.0;
        assertEquals(-1.0, instance.calcular(montoVentaMensual));
    }

    public void testMontoVentaLimiteInferior() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = 0.0;
        assertEquals(0.0, instance.calcular(montoVentaMensual));
    }


    @Test
    public void testSetAndGetRangoValues() {
        Rango rango = new Rango(1000.0, 2000.0, 0.05);
        rango.setMenor(1500.0);
        rango.setMayor(2500.0);
        rango.setValor(0.10);
        assertEquals(1500.0, rango.getMenor());
        assertEquals(2500.0, rango.getMayor());
        assertEquals(0.10, rango.getValor());
    }

    @Test
    public void testSinRango() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();
        Double montoVentaSinRango = 1500.005;
        assertEquals(-1.0, instance.calcular(montoVentaSinRango));

    }


    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ComisionVenta.main(args);
    }

}
