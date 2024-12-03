package cr.go.ucr.examen1;

import java.util.Arrays;
import java.util.List;

public class ComisionVenta {
    
    private static final ComisionVenta currentInstance = new ComisionVenta();
    
    private ComisionVenta() {}
    
    public List<Rango> rangos = Arrays.asList(
        new Rango(1.0, 1500.00, 0.03),
        new Rango(1500.01, 5000.00, 0.07),
        new Rango(5000.01, 15000.00, 0.12),
        new Rango(15000.00, 100000.00, 0.15)
    );
    
    public Double calcular(Double montoVentaMensual) {
        // Verifica si el monto es null o negativo
        if (montoVentaMensual == null || montoVentaMensual < 0.0) {
            return -1.0;  // Valores negativos o nulos son inválidos
        }

        // Verifica valores muy pequeños como 0.00001, que deberían tratarse como 0
        if (montoVentaMensual < 0.01) {
            return 0.0;  // Consideramos valores muy pequeños como 0
        }

        // Verifica si el monto está fuera del rango válido
        if (montoVentaMensual > 100000.00) {
            return -1.0;  // Valores mayores que 100,000 también son inválidos
        }

        // Verifica en qué rango está el monto y calcula la comisión
        for (Rango r : rangos) {
            if (r.getMenor() <= montoVentaMensual && montoVentaMensual <= r.getMayor()) {
                return montoVentaMensual * r.getValor();
            }
        }

        // Si el monto no está en ninguno de los rangos válidos
        return -1.0;
    }
    
    public static ComisionVenta getCurrentInstance() {
        return currentInstance;
    }
}
