
package observer;

public class Logistica implements Observador {
    public void actualizar(String estado) {
        System.out.println("Logistica notificada: " + estado);
    }
}
