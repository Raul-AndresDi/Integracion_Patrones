
package decorator;

// Decorador abstracto: envuelve otro Notificador
public abstract class NotificacionDecorator implements Notificador {
    protected Notificador notificador;

    public NotificacionDecorator(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(String mensaje) {
        notificador.enviar(mensaje);
    }
}