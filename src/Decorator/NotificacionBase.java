
package decorator;

// Notificación básica (sin decorar)
public class NotificacionBase implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[Notificador] " + mensaje);
    }
}