import java.time.LocalDate;

public class Usuario {
	String nombre;
	LocalDate fecha;
	@Override
	public String toString() {
		return "\nBienvenido " + nombre + " hoy es " + fecha + " y vamos a intentar adivinar un número entre 1 y 1000000.";
	}
}
