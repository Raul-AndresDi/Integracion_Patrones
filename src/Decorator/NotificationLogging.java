
package decorator;

// Decorador que agrega logging antes y después de enviar
public class NotificationLogging extends NotificacionDecorator {

    public NotificationLogging(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[LOG] Enviando notificacion...");
        notificador.enviar(mensaje);
        System.out.println("[LOG] Notificacion enviada correctamente.");
    }
}