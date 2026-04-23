
package factory;

import model.Pedido;

public class FabricaPedidos {

    // Oculta el 'new' y devuelve el tipo correcto según el destino
    public static Pedido crearPedido(String tipo, double peso) {
        switch (tipo.toUpperCase()) {
            case "NACIONAL":
                return new PedidoNacional(peso);
            case "INTERNACIONAL":
                return new PedidoInternacional(peso);
            default:
                throw new IllegalArgumentException("Tipo de pedido desconocido: " + tipo);
        }
    }
}