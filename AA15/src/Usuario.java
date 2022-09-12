import java.time.LocalDate;

public class Usuario
{
    int id;
    String nombre;
    LocalDate fecha;
    
    public Usuario(final int id, final String nombre, final LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return "Usuario [id=" + this.id + ", nombre=" + this.nombre + ", fecha=" + this.fecha + "]";
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public LocalDate getFecha() {
        return this.fecha;
    }
    
    public void setFecha(final LocalDate fecha) {
        this.fecha = fecha;
    }
}