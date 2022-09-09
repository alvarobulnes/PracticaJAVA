import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements ProduccionActiva {
	public boolean produccionActiva(int temperatura) {
		boolean hayProduccion = false;
		if (temperatura < 40) {
			hayProduccion = true;
		}

		return hayProduccion;
	}

	public static void main(String[] args) {
		Main m = new Main();

		Chocolate blanco = new Chocolate("Chocolate Blanco", 1000);
		Chocolate negro = new Chocolate("Chocolate Negro", 1500);
		Chocolate alm = new Chocolate("Chocolate con almendras", 1200);
		Chocolate rama = new Chocolate("Chocolate en rama", 100);

		ArrayList<Chocolate> chocolates = new ArrayList();
		chocolates.add(blanco);
		chocolates.add(negro);
		chocolates.add(alm);
		chocolates.add(rama);

		try {

			// Sacamos la temperatura
			String temperatura = "";
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/41");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();

			int tiempoRespuesta = conn.getResponseCode();

			if (tiempoRespuesta != 200) {
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			} else {
				Scanner sc1 = new Scanner(url.openStream());
				while (sc1.hasNext()) {
					temperatura = sc1.nextLine();
					temperatura = temperatura.substring(temperatura.indexOf("\"temperatures\""),
							temperatura.indexOf("\"temperatures\"") + 26);
					temperatura = temperatura.replace("{", "");
					temperatura = temperatura.replaceAll("\"", "");
					temperatura = temperatura.substring(temperatura.length() - 2);
					// System.out.println(temperatura);
				}
				sc1.close();

			}

			// Sacamos por pantalla y txt
			if (m.produccionActiva(Integer.parseInt(temperatura)) == true) {
				System.out.println("Hoy si se producir� chocolate.");
				File doc = new File("salida_0909.txt");
				doc.createNewFile();
				FileWriter fw = new FileWriter(doc);
				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < chocolates.size(); i++) {
					System.out.println(chocolates.get(i).toString());
					bw.write(chocolates.get(i).toString() + "\n");
				}

				System.out.println("\nArchivo de texto creado correctamente.");
				bw.close();
			} else {
				System.out.println("Hoy no habr� producci�n de chocolate, ya que la temperatura es de " + temperatura);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Generaci�n del Jenkins

		File jenkins = new File("Jenkinsfile");
		try {
			jenkins.createNewFile();
			FileWriter fw = new FileWriter(jenkins);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("pipeline {\r\n" + "    agent any\r\n" + "    stages{\r\n" + "        \r\n"
					+ "        stage('mostrarFecha') {\r\n" + "            steps {\r\n" + "                script{\r\n"
					+ "                    def dia = new Date()\r\n"
					+ "                    println(\"Chocolate Blanco:  1000\r\n"
					+ "Chocolate Negro:  1500\r\n"
					+ "Chocolate con almendras:  1200\r\n"
					+ "Chocolate en rama:  100\r\n"
					+ "                }\r\n" + "            }\r\n" + "        }\r\n" + "            \r\n" + "    }\r\n"
					+ "}");

			bw.close();
			System.out.println("\nArchivo Jenkins generado correctamente.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

interface ProduccionActiva {
	public boolean produccionActiva(int temperatura);
}
