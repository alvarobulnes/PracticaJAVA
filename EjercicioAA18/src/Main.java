import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.ConfigurarSpring;
import spring.Servicio;


public class Main {

	public static float calcularPIB(long n1, float n2, Pib formato) {
		float resultado = formato.ejecutar(n1, n2);
		
		return resultado;
	}
	

	public static void main(String[] args) {
		File infoPaises = new File("C:\\Users\\bulne\\Desktop\\INFO_PAISES.txt");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class);
		Servicio servicio = ctx.getBean(Servicio.class);
		
		try {
			FileReader fr;
			fr = new FileReader(infoPaises);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			int numLinea = 1;
			ArrayList<Pais> paises = new ArrayList<Pais>();
			Pais arg = new Pais();
			Pais esp = new Pais();
			Pais ale = new Pais();
			Pais bra = new Pais();
			Pib pib_lambda = (long t1, float t2) -> t1 * t2;
			String nombre = "", cont = "", capital = "", clima = "";
			long habit = 0;
			float salario = 0;

			while ((linea = br.readLine()) != null) {
				// arg
				if (numLinea <= 6) {

					if (linea.toLowerCase().contains("pais")) {
						nombre = linea.substring(linea.indexOf(" ") + 1, linea.length());
						arg.nombre = nombre;
					}

					if (linea.toLowerCase().contains("continente")) {
						cont = linea.substring(linea.indexOf(" ") + 1, linea.length());
						arg.continente = cont;
					}
					if (linea.toLowerCase().contains("capital")) {
						capital = linea.substring(linea.indexOf(" ") + 1, linea.length());
						arg.capital = capital;
					}
					if (linea.toLowerCase().contains("habitantes")) {
						habit = Long.parseLong(linea.substring(linea.indexOf(" ") + 1, linea.length()));
						arg.habitantes = habit;
					}
					if (linea.toLowerCase().contains("clima")) {
						clima = linea.substring(linea.indexOf(" ") + 1, linea.length());
						arg.clima = clima;
					}
					if (linea.toLowerCase().contains("salario")) {
						salario = Float.parseFloat(linea.substring(linea.indexOf(": ") + 1, linea.length()));
						arg.salario = salario;
					}
					arg.pib = calcularPIB(arg.habitantes, arg.salario, pib_lambda);

				}
				paises.add(arg);

				// esp
				if (numLinea >= 7 && numLinea <= 12) {
					if (linea.toLowerCase().contains("pais")) {
						nombre = linea.substring(linea.indexOf(" ") + 1, linea.length());
						esp.nombre = nombre;
					}

					if (linea.toLowerCase().contains("continente")) {
						cont = linea.substring(linea.indexOf(" ") + 1, linea.length());
						esp.continente = cont;
					}
					if (linea.toLowerCase().contains("capital")) {
						capital = linea.substring(linea.indexOf(" ") + 1, linea.length());
						esp.capital = capital;
					}
					if (linea.toLowerCase().contains("habitantes")) {
						habit = Long.parseLong(linea.substring(linea.indexOf(" ") + 1, linea.length()));
						esp.habitantes = habit;
					}
					if (linea.toLowerCase().contains("clima")) {
						clima = linea.substring(linea.indexOf(" ") + 1, linea.length());
						esp.clima = clima;
					}
					if (linea.toLowerCase().contains("salario")) {
						salario = Float.parseFloat(linea.substring(linea.indexOf(": ") + 1, linea.length()));
						esp.salario = salario;
					}
					
					esp.pib = calcularPIB(esp.habitantes, esp.salario, pib_lambda);

				}
				paises.add(esp);

				// ale
				if (numLinea >= 13 && numLinea <= 18) {
					if (linea.toLowerCase().contains("pais")) {
						nombre = linea.substring(linea.indexOf(" ") + 1, linea.length());
						ale.nombre = nombre;
					}

					if (linea.toLowerCase().contains("continente")) {
						cont = linea.substring(linea.indexOf(" ") + 1, linea.length());
						ale.continente = cont;
					}
					if (linea.toLowerCase().contains("capital")) {
						capital = linea.substring(linea.indexOf(" ") + 1, linea.length());
						ale.capital = capital;
					}
					if (linea.toLowerCase().contains("habitantes")) {
						habit = Long.parseLong(linea.substring(linea.indexOf(" ") + 1, linea.length()));
						ale.habitantes = habit;
					}
					if (linea.toLowerCase().contains("clima")) {
						clima = linea.substring(linea.indexOf(" ") + 1, linea.length());
						ale.clima = clima;
					}
					if (linea.toLowerCase().contains("salario")) {
						salario = Float.parseFloat(linea.substring(linea.indexOf(": ") + 1, linea.length()));
						ale.salario = salario;
					}
					
					esp.pib = calcularPIB(esp.habitantes, esp.salario, pib_lambda);

				}
				paises.add(ale);

				// bra
				if (numLinea >= 19 && numLinea <= 24) {
					if (linea.toLowerCase().contains("pais")) {
						nombre = linea.substring(linea.indexOf(" ") + 1, linea.length());
						bra.nombre = nombre;
					}

					if (linea.toLowerCase().contains("continente")) {
						cont = linea.substring(linea.indexOf(" ") + 1, linea.length());
						bra.continente = cont;
					}
					if (linea.toLowerCase().contains("capital")) {
						capital = linea.substring(linea.indexOf(" ") + 1, linea.length());
						bra.capital = capital;
					}
					if (linea.toLowerCase().contains("habitantes")) {
						habit = Integer.parseInt(linea.substring(linea.indexOf(" ") + 1, linea.length()));
						bra.habitantes = habit;
					}
					if (linea.toLowerCase().contains("clima")) {
						clima = linea.substring(linea.indexOf(" ") + 1, linea.length());
						bra.clima = clima;
					}
					if (linea.toLowerCase().contains("salario")) {
						salario = Float.parseFloat(linea.substring(linea.indexOf(": ") + 1, linea.length()));
						bra.salario = salario;
					}
					
					esp.pib = calcularPIB(esp.habitantes, esp.salario, pib_lambda);

				}
				paises.add(bra);
				numLinea++;

			}
			br.close();
			
			for (int i = 0; i < paises.size(); i++) {
				String nombreArchivo = paises.get(i).nombre.toLowerCase() + ".txt";
				File archivo = new File(nombreArchivo);
				archivo.createNewFile();
				FileWriter fw = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(paises.get(i).toString());
				bw.close();
			}
			
			servicio.generarTxt();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

interface Pib {
	float ejecutar(long n1, float n2);
}
