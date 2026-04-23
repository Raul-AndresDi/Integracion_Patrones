
import decorator.NotificacionBase;
import decorator.NotificationCifrado;
import decorator.NotificationLogging;
import decorator.Notificador;
import factory.FabricaPedidos;
import model.Pedido;
import observer.Cliente;
import observer.Logistica;
import singleton.Configuracion;
import strategy.EnvioExpress;
import strategy.EnvioProgramado;

public class Main {

    public static void main(String[] args) {

        // ─────────────────────────────────────────
        // 1. SINGLETON – Configuración global
        // ─────────────────────────────────────────
        System.out.println("=== SINGLETON ===");
        Configuracion config = Configuracion.getInstancia();
        System.out.println(config);
        // Verificar que es la misma instancia
        Configuracion config2 = Configuracion.getInstancia();
        System.out.println(" Misma instancia? " + (config == config2));

        System.out.println();

        // ─────────────────────────────────────────
        // 2. FACTORY – Crear pedidos sin usar 'new'
        // ─────────────────────────────────────────
        System.out.println("=== FACTORY ===");
        Pedido pedido = FabricaPedidos.crearPedido("NACIONAL", 3.5);

        System.out.println();

        // ─────────────────────────────────────────
        // 3. OBSERVER – Suscribir observadores
        // ─────────────────────────────────────────
        System.out.println("=== OBSERVER ===");
        Cliente cliente = new Cliente();
        Logistica logistica = new Logistica();
        pedido.agregarObservador(cliente);
        pedido.agregarObservador(logistica);

        // Cambios de estado → se notifica automáticamente
        pedido.setEstado("EN_PREPARACION");
        pedido.setEstado("ENVIADO");
        pedido.setEstado("ENTREGADO");

        System.out.println();

        // ─────────────────────────────────────────
        // 4. STRATEGY – Cambio dinámico de estrategia
        // ─────────────────────────────────────────
        System.out.println("=== STRATEGY ===");
        System.out.printf("Costo con EnvioEstandar:   $%,.0f %s%n",
                pedido.calcularEnvio(), config.getMoneda());

        // Cambio dinámico a Express
        pedido.setEstrategia(new EnvioExpress());
        System.out.printf("Costo con EnvioExpress:    $%,.0f %s%n",
                pedido.calcularEnvio(), config.getMoneda());

        // Cambio dinámico a Programado
        pedido.setEstrategia(new EnvioProgramado());
        System.out.printf("Costo con EnvioProgramado: $%,.0f %s%n",
                pedido.calcularEnvio(), config.getMoneda());

        // Aplicar impuesto del Singleton
        double costoFinal = pedido.calcularEnvio() * (1 + config.getImpuesto());
        System.out.printf("Costo final con IVA (%.0f%%): $%,.0f %s%n",
                config.getImpuesto() * 100, costoFinal, config.getMoneda());

        System.out.println();

        // ─────────────────────────────────────────
        // 5. DECORATOR – Extender notificaciones
        // ─────────────────────────────────────────
        System.out.println("=== DECORATOR ===");

        // Notificación básica
        Notificador base = new NotificacionBase();
        base.enviar("Pedido entregado exitosamente.");

        System.out.println();

        // Con Logging
        Notificador conLogging = new NotificationLogging(new NotificacionBase());
        conLogging.enviar("Pedido entregado exitosamente.");

        System.out.println();

        // Con Cifrado + Logging (decoradores apilados)
        Notificador conCifradoYLogging =
                new NotificationLogging(
                    new NotificationCifrado(
                        new NotificacionBase()));
        conCifradoYLogging.enviar("Pedido entregado exitosamente.");
    }
}