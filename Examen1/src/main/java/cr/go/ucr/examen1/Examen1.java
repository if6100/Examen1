/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cr.go.ucr.examen1;

/**
 *
 * @author Admin
 */
public class Examen1 {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
       System.out.println("Comision para venta de -0.01 (valor inválido): " + ComisionVenta.getCurrentInstance().calcular(-0.01));
    System.out.println("Comision para venta de 1000.00 (Rango Bajo): " + ComisionVenta.getCurrentInstance().calcular(1000.0));
    System.out.println("Comision para venta de 3000.00 (Rango Intermedio): " + ComisionVenta.getCurrentInstance().calcular(3000.0));
    System.out.println("Comision para venta de 120000.00 (Fuera de Rango): " + ComisionVenta.getCurrentInstance().calcular(120000.0));
    System.out.println("Comision para venta de 0.0 (Monto Cero): " + ComisionVenta.getCurrentInstance().calcular(0.0));
    System.out.println("Comision para venta de 50000.00 (Rango Alto): " + ComisionVenta.getCurrentInstance().calcular(50000.0));
    }
}

