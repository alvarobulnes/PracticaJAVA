package spring;
import org.springframework.stereotype.Service;

@Service
public class Servicio {
	public void generarTxt() {
		
	}
	
	public void comprobarTxt(String nombre) {
		if(nombre.contains(".txt")) {
			System.out.println("El archivo es un txt.");
		}else {
			System.out.println("El archivo no es un txt.");
		}
		
	}
	
	public void salidaPrograma() {
		
	}
}
