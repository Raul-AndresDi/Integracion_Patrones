
package singleton;

public class Configuracion {

    private static Configuracion instancia;

    private double impuesto;
    private String moneda;
    private double descuento;

    // Constructor privado: nadie puede hacer new ConfiguracionSistema()
    private Configuracion() {
        this.impuesto  = 0.19;   // 19 % IVA
        this.moneda    = "COP";
        this.descuento = 0.05;   // 5 % de descuento general
    }

    // Punto de acceso global único
    public static Configuracion getInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    // Getters y setters
    public double getImpuesto()          { return impuesto; }
    public String getMoneda()            { return moneda; }
    public double getDescuento()         { return descuento; }

    public void setImpuesto(double v)    { this.impuesto  = v; }
    public void setMoneda(String m)      { this.moneda    = m; }
    public void setDescuento(double d)   { this.descuento = d; }

    @Override
    public String toString() {
        return "[ConfiguracionSistema] Moneda=" + moneda
             + " | Impuesto=" + (impuesto * 100) + "%"
             + " | Descuento=" + (descuento * 100) + "%";
    }
}