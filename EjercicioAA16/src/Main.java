import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import spring.*;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.ConfigurarSpring;
import spring.Servicio;

public class Main implements Recaudacion {
	public double calcularRecaudacion(double visitas) {
		return visitas * 2;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class);
		Servicio servicio = ctx.getBean(Servicio.class);
		Main m = new Main();
		File archivoCanciones20, archivoCanciones21, archivoArtistas20, archivoArtistas21;
		File archivo = new File("archivo_salida_canciones.txt");
		servicio.generarTxt();

		// Lectura del fichero e introducción en otro fichero de canciones 2020
		try {
			String nombreArchivo = "C:\\Users\\bulne\\Desktop\\Canciones_2020.txt";
			servicio.comprobarTxt(nombreArchivo);
			archivoCanciones20 = new File(nombreArchivo);
			FileReader fr = new FileReader(archivoCanciones20);
			BufferedReader br = new BufferedReader(fr);

			if (archivo.exists()) {
				archivo.delete();
			}

			archivo.createNewFile();
			
			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String linea, nombreCancion;
			String views;
			bw.write("TOP 10 CANCIONES 2020:\n");
			while ((linea = br.readLine()) != null) {
				nombreCancion = linea.substring(0, linea.indexOf("  "));
				views = linea.substring(linea.indexOf("  "), linea.length() - 1);

				bw.write(nombreCancion + "  " + m.calcularRecaudacion(Double.parseDouble(views)) + "€\n");
			}
			br.close();

			bw.close();

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Lectura del fichero e introducción en otro fichero canciones 2021
		try {
			archivoCanciones21 = new File("C:\\Users\\bulne\\Desktop\\Canciones_2021.txt");
			FileReader fr = new FileReader(archivoCanciones21);
			BufferedReader br = new BufferedReader(fr);

			archivo.createNewFile();
			
			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String linea, nombreCancion;
			String views;

			bw.write("\nTOP 10 CANCIONES 2021:\n");
			while ((linea = br.readLine()) != null) {
				nombreCancion = linea.substring(0, linea.indexOf("  "));
				views = linea.substring(linea.indexOf("  "), linea.length() - 1);

				bw.write(nombreCancion + "  " + m.calcularRecaudacion(Double.parseDouble(views)) + "€\n");
			}
			br.close();

			bw.close();

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Lectura del fichero e introducción en otro fichero artistas 2020
		try {
			archivoArtistas20 = new File("C:\\Users\\bulne\\Desktop\\Artistas_2020.txt");
			FileReader fr = new FileReader(archivoArtistas20);
			BufferedReader br = new BufferedReader(fr);

			archivo.createNewFile();
			
			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String linea;

			bw.write("\nTOP 10 ARTISTAS 2020:\n");
			while ((linea = br.readLine()) != null) {

				bw.write(linea + "\n");
			}
			br.close();

			bw.close();

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Lectura del fichero e introducción en otro fichero artistas 2021
		try {
			archivoArtistas21 = new File("C:\\Users\\bulne\\Desktop\\Artistas_2021.txt");
			FileReader fr = new FileReader(archivoArtistas21);
			BufferedReader br = new BufferedReader(fr);

			archivo.createNewFile();
			
			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String linea;

			bw.write("\nTOP 10 ARTISTAS 2021:\n");
			while ((linea = br.readLine()) != null) {

				bw.write(linea + "\n");
			}
			br.close();

			bw.close();

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		servicio.salidaPrograma();

	}

}

interface Recaudacion {
	public double calcularRecaudacion(double visitas);
}
