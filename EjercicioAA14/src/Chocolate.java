
public class Chocolate extends Golosina{
	private String nombre;
	private int cantidad;

	@Override
	public String toString() {
		return nombre + ":  " + cantidad;
	}

	public Chocolate(String nombre, int cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
