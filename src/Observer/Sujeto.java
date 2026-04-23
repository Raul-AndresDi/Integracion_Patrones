
package observer;

import java.util.ArrayList;
import java.util.List;

public class Sujeto {
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void notificar(String estado) {
        for (Observador o : observadores) {
            o.actualizar(estado);
        }
    }
}