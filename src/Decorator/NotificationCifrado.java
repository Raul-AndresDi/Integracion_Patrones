
package decorator;

import java.util.Base64;

// Decorador que cifra el mensaje (Base64 como simulación de cifrado)
public class NotificationCifrado extends NotificacionDecorator {

    public NotificationCifrado(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        String cifrado = Base64.getEncoder().encodeToString(mensaje.getBytes());
        System.out.println("[CIFRADO] Mensaje cifrado: " + cifrado);
        notificador.enviar(mensaje);
    }
}