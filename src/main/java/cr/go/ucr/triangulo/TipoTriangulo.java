/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cr.go.ucr.triangulo;

/**
 *
 * @author JeArag
 */
public enum TipoTriangulo {
    NO_TRIANGULO("NT"),ESCALENO("ES"),EQUILATERO("EQ"),ISOCELES("IS");
    private String nombre;
    private TipoTriangulo(String nombre){this.nombre=nombre;}

    public String getNombre() {
        //documentacion 123

        return nombre;

    }
    
    
}
