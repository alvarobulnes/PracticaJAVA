public class Provincia extends Capital
{
    String nombre;
    String nombreCapital;
    
    public Provincia(final String nombre, final String nombreCapital) {
        this.nombre = nombre;
        this.nombreCapital = nombreCapital;
    }
    
    public String toString() {
        return "Nombre=" + this.nombre + ", Capital=" + this.nombreCapital;
    }
}