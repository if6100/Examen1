package cr.go.ucr.examen1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComisionVentaTest {

    @Test
    public void testCalcular_ValoresValidos() {
        // Instancia del sistema bajo prueba
        ComisionVenta instance = ComisionVenta.getCurrentInstance();

        // Prueba cada rango válido
        assertEquals(45.0, instance.calcular(1500.0), 0.001, "Fallo para rango 0 - 1500");
        assertEquals(350.0, instance.calcular(5000.0), 0.001, "Fallo para rango 1500.01 - 5000");
        assertEquals(1800.0, instance.calcular(15000.0), 0.001, "Fallo para rango 5000.01 - 15000");
        assertEquals(15000.0, instance.calcular(100000.0), 0.001, "Fallo para rango 15000.01 - 100000");
    }

    @Test
    public void testCalcular_ValoresInvalidos() {
        ComisionVenta instance = ComisionVenta.getCurrentInstance();

        // Prueba valores fuera del rango permitido
        assertEquals(-1.0, instance.calcular(-1.0), 0.001, "Fallo para monto menor que 0");
        assertEquals(-1.0, instance.calcular(100001.0), 0.001, "Fallo para monto mayor que 100000");
        assertEquals(-1.0, instance.calcular(null), 0.001, "Fallo para monto nulo");
    }

    @Test
    public void testGetCurrentInstance() {
        // Verifica que se retorne la misma instancia (singleton)
        ComisionVenta instance1 = ComisionVenta.getCurrentInstance();
        ComisionVenta instance2 = ComisionVenta.getCurrentInstance();
        assertNotNull(instance1, "La instancia no debería ser nula");
        assertSame(instance1, instance2, "Las instancias deberían ser iguales (singleton)");
    }

    @Test
    public void testMain() {
        // Prueba del método main, simplemente verifica que se ejecute sin errores
        ComisionVenta.main(new String[]{});
        assertTrue(true, "El método main se ejecutó correctamente");
    }
}

