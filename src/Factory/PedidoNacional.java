
package factory;

import model.Pedido;
import strategy.EnvioEstandar;
import strategy.EnvioExpress;

// Pedido nacional
public class PedidoNacional extends Pedido {
    public PedidoNacional(double peso) {
        super(peso, new EnvioEstandar());
        System.out.println("[Factory] Creando PedidoNacional (peso=" + peso + " kg)");
    }
}