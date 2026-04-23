package observer;

public class Cliente implements Observador {
    public void actualizar(String estado) {
        System.out.println("Cliente notificado: " + estado);
    }
}
