package cr.go.ucr.examen1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jesus Rodriguez - C16536
 * @date 3 dic. 2024
 */
public class ComisionVentaTest {

    @Test
    public void validarMontoNegativo() {
        ComisionVenta instancia = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = -1.0;
        assertEquals(-1.0, instancia.calcular(montoVentaMensual));
    }

    @Test
    public void calcularComisionPrimerRango() {
        ComisionVenta instancia = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = 3000.0;
        assertEquals(210.00000000000003, instancia.calcular(montoVentaMensual));
    }

    @Test
    public void verificarMontoExcedeLimite() {
        ComisionVenta instancia = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = 100001.0;
        assertEquals(-1.0, instancia.calcular(montoVentaMensual));
    }

    @Test
    public void evaluarMontoMinimoPermitido() {
        ComisionVenta instancia = ComisionVenta.getCurrentInstance();
        Double montoVentaMensual = 0.0;
        assertEquals(0.0, instancia.calcular(montoVentaMensual));
    }

    @Test
    public void verificarGettersYSettersDeRango() {
        Rango rango = new Rango(1000.0, 2000.0, 0.05);
        rango.setMenor(1500.0);
        rango.setMayor(2500.0);
        rango.setValor(0.10);
        assertEquals(1500.0, rango.getMenor());
        assertEquals(2500.0, rango.getMayor());
        assertEquals(0.10, rango.getValor());
    }

    @Test
    public void calcularComisionFueraDeRangosDefinidos() {
        ComisionVenta instancia = ComisionVenta.getCurrentInstance();
        Double montoVentaSinRango = 1500.005;
        assertEquals(-1.0, instancia.calcular(montoVentaSinRango));
    }

    @Test
    public void ejecutarMetodoMain() {
        String[] argumentos = null;
        ComisionVenta.main(argumentos);
    }
}
