

import cr.go.ucr.examen2.ComisionVenta;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestC26662JonathanRodriguez {

    @Test
    public void testComisionMenorA1500() {
        
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(1000.0);
        assertEquals(30.0, resultado, "La comisión debe ser 30.0");
    }

   @Test
    public void testComisionEntre1500Y5000() {
        
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(3000.0);
        
        
        assertEquals(210.0, resultado, 0.0001, "La comisión debe ser 210.0");
    }

    @Test
    public void testComisionMayorA100000() {
        
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(150000.0);
        assertEquals(-1.0, resultado, "El monto mayor a 100000 debería devolver -1");
    }

    @Test
    public void testComisionNegativa() {
        
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(-500.0);
        assertEquals(-1.0, resultado, "El monto negativo debería devolver -1");
    }
    
    
    //Inician Pruebas de caja Blanca/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    @Test
    public void testComisionMenorQueCero() {
        // Caso donde el monto de ventas es menor que 0
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(-1.0);
        assertEquals(-1.0, resultado, "El monto no puede ser menor que 0.");
    }

    @Test
    public void testComisionMayorQueCienMil() {
        // Caso donde el monto de ventas es mayor que 100,000
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(150000.0);
        assertEquals(-1.0, resultado, "El monto no puede ser mayor a 100,000.");
    }

    @Test
    public void testComisionEntre0Y1500() {
        // Caso donde el monto de ventas está entre 0 y 1500
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(1500.0);
        assertEquals(45.0, resultado, "La comisión debe ser 45.0");
    }

    @Test
    public void testComisionEntre5000Y15000() {
        // Caso donde el monto de ventas está entre 5000.01 y 15000
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(10000.0);
        assertEquals(1200.0, resultado, "La comisión debe ser 1200.0");
    }

    @Test
    public void testComisionEntre15000Y100000() {
        // Caso donde el monto de ventas está entre 15000.01 y 100000
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        double resultado = comisionVenta.calcular(50000.0);
        assertEquals(7500.0, resultado, "La comisión debe ser 7500.0");
    }
}
