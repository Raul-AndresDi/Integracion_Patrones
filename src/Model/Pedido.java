package model;

import observer.Sujeto;
import strategy.EstrategiaEnvio;

public class Pedido extends Sujeto {
    private String estado;
    private EstrategiaEnvio estrategia;
    private double peso;

    public Pedido(double peso, EstrategiaEnvio estrategia) {
        this.peso = peso;
        this.estrategia = estrategia;
        this.estado = "CREADO";
    }

    public void setEstado(String estado) {
        this.estado = estado;
        notificar(estado);
    }

    public void setEstrategia(EstrategiaEnvio estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularEnvio() {
        return estrategia.calcularCosto(peso);
    }
}