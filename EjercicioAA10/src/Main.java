import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Introduzca su nombre: ");
			String nombre = sc.nextLine();
			System.out.println("\nBienvenido " + nombre);
			System.out.println("El tiempo en Sevilla es:");
			sc.close();
			
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/41"); 
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();

			int tiempoRespuesta = conn.getResponseCode();
			
			if (tiempoRespuesta != 200) {
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			} else {
				Scanner sc1 = new Scanner(url.openStream());

				
				while (sc1.hasNext()) {
					String linea = sc1.nextLine();
					linea = linea.replaceAll("}", "");
					linea = linea.replace("{", "");
					linea = linea.replaceAll(",", "\n");
					linea = linea.replaceAll("\"", "");
					//linea = linea.replaceAll("d\u00eda", "dia");
					//linea = linea.replaceAll("Campi\\u00f1a.", "campiña");
					linea = linea.trim();
					linea = linea.substring(0, 385);
					System.out.println(linea);
					
				}
				sc1.close();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
