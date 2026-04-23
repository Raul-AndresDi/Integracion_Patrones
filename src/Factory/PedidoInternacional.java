package factory;

import model.Pedido;
import strategy.EnvioExpress;


public class PedidoInternacional extends Pedido {
    public PedidoInternacional(double peso) {
        super(peso, new EnvioExpress());
        System.out.println("[Factory] Creando PedidoInternacional (peso=" + peso + " kg)");
    }
}