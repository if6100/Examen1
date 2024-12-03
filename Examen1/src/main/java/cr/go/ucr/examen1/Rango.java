package cr.go.ucr.examen1;

/**
 * @author Jesus Rodriguez - C16536
 * @date 3 dic. 2024
 */
public class Rango {

    private Double menor;
    private Double mayor;
    private Double valor;

    public Rango(Double menor, Double mayor, Double valor) {
        this.menor = menor;
        this.mayor = mayor;
        this.valor = valor;
    }

    public Double getMenor() {
        return menor;
    }

    public void setMenor(Double menor) {
        this.menor = menor;
    }

    public Double getMayor() {
        return mayor;
    }

    public void setMayor(Double mayor) {
        this.mayor = mayor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
