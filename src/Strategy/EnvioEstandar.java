package strategy;

public class EnvioEstandar implements EstrategiaEnvio {
    public double calcularCosto(double peso) {
        return peso * 5000;
    }
}