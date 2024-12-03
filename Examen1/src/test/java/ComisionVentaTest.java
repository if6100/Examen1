
import cr.go.ucr.examen1.ComisionVenta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComisionVentaTest {

    private final ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();

    // ---------------------
    // PRUEBAS DE CAJA NEGRA
    // ---------------------
    @Test
    void testCajaNegraRango_0_1500() {
        Double montoVentaMensual = 1000.00;
        Double expected = 30.00;
        Double actual = comisionVenta.calcular(montoVentaMensual);
        assertEquals(expected, actual, 0.0001, "Error en rango [0.0, 1500.00]");
    }

    @Test
    void testCajaNegraValorMenorACero() {
        Double montoVentaMensual = -50.00;
        Double expected = -1.0; 
        Double actual = comisionVenta.calcular(montoVentaMensual);
        assertEquals(expected, actual, "Error en valores menores a 0.0");
    }

    @Test
    void testCajaNegraRango_15000_100000() {
        Double montoVentaMensual = 50000.00;
        Double expected = 7500.00; 
        Double actual = comisionVenta.calcular(montoVentaMensual);
        assertEquals(expected, actual, 0.0001, "Error en rango [15,000.01, 100,000.00]");
    }

    // ---------------------
    // PRUEBAS DE CAJA BLANCA
    // ---------------------

    @Test
    void testCajaBlancaNull() {
        Double montoVentaMensual = null;
        Double expected = -1.0;
        Double actual = comisionVenta.calcular(montoVentaMensual);
        assertEquals(expected, actual, "Error en caso de entrada nula");
    }

    @Test
    void testCajaBlancaNoPerteneceARangos() {
        Double montoVentaMensual = 100000.01;
        Double expected = -1.0;
        Double actual = comisionVenta.calcular(montoVentaMensual);
        assertEquals(expected, actual, "Error en valores fuera de los rangos");
    }

    @Test
    void testCajaBlancaCadaRango() {
        assertEquals(45.00, comisionVenta.calcular(1500.00), 0.0001, "Error en límite [0.0, 1500.00]");
        assertEquals(315.00, comisionVenta.calcular(4500.00), 0.0001, "Error en rango [1500.01, 5000.00]");
        assertEquals(1200.00, comisionVenta.calcular(10000.00), 0.0001, "Error en rango [5000.01, 15000.00]");
        assertEquals(2250.15, comisionVenta.calcular(15001.00), 0.0001, "Error en rango [15000.01, 100000.00]");
    }

    @Test
    void testCajaBlancaValorEnElLímiteSuperior() {
        Double montoVentaMensual = 100000.00;
        Double expected = 15000.00; 
        Double actual = comisionVenta.calcular(montoVentaMensual);
        assertEquals(expected, actual, 0.0001, "Error en límite superior [15,000.01, 100,000.00]");
    }

    @Test
    void testCajaBlancaValorNegativoNoProcesado() {
        Double montoVentaMensual = -0.01;
        Double expected = -1.0; 
        Double actual = comisionVenta.calcular(montoVentaMensual);
        assertEquals(expected, actual, "Error en límite inferior (< 0.0)");
    }
}