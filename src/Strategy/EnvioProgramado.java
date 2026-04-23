
package strategy;

public class EnvioProgramado implements EstrategiaEnvio {
    public double calcularCosto(double peso) {
        return peso * 3000;
    }
}