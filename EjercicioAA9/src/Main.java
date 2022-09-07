import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main implements CalcularTotal {

	public double calcularTotal(int nCopias, double precio) {
		double dineroTotal;
		dineroTotal = nCopias * precio;

		return dineroTotal;
	}

	public static void main(String[] args) {
		Main m = new Main();
		// Videojuego(String nombre, String categoria, double precio, int nCopias, int
		// horas)
		Videojuego darkSouls3 = new Videojuego("Dark Souls 3", "RPG", 14.99, 10000, 50);
		Videojuego lastOfUs = new Videojuego("The Last of Us", "acción", 10, 50000, 12);
		Videojuego fifa22 = new Videojuego("FIFA 22", "emulador", 49.99, 60000, 2000);
		Videojuego marioBros = new Videojuego("Mario Bros", "arcade", 39.90, 45000, 30);
		Videojuego fortnite = new Videojuego("Fortnite", "Battle Royale", 0.00, 100000, 5000);
		Videojuego horizon = new Videojuego("Horizon: Forbidden West", "aventura", 63.99, 50000, 95);

		ArrayList<Videojuego> videojuegos = new ArrayList();
		videojuegos.add(darkSouls3);
		videojuegos.add(lastOfUs);
		videojuegos.add(fifa22);
		videojuegos.add(marioBros);
		videojuegos.add(fortnite);
		videojuegos.add(horizon);

		try {

			File doc = new File("salida_ejAA9_0922.txt");
			doc.createNewFile();
			FileWriter fw = new FileWriter(doc);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Videojuegos:\n");
			for (int i = 0; i < videojuegos.size(); i++) {
				bw.write(videojuegos.get(i).toString() + ", dinero total="+ m.calcularTotal(videojuegos.get(i).getnCopias(), videojuegos.get(i).getPrecio()) + "€\n");
			}
			System.out.println("Archivo creado correctamente.");
			bw.close();
		} catch (IOException ioe) {
			// TODO: handle exception
		}

	}

}

interface CalcularTotal {
	public double calcularTotal(int nCopias, double precio);
}
