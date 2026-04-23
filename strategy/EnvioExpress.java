package strategy;

public class EnvioExpress implements EstrategiaEnvio {
    public double calcularCosto(double peso) {
        return peso * 10000;
    }
}
