
public class Videojuego {
	private String nombre;
	private String categoria;
	private double precio;
	private int nCopias;
	private int horas;

	public Videojuego(String nombre, String categoria, double precio, int nCopias, int horas) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.nCopias = nCopias;
		this.horas = horas;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + "€, nCopias="
				+ nCopias + ", horas=" + horas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getnCopias() {
		return nCopias;
	}

	public void setnCopias(int nCopias) {
		this.nCopias = nCopias;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

}
