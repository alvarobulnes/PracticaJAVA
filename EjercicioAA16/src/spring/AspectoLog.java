package spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class AspectoLog {
	@Before("execution(* generarTxt())") 
	public void log1() {
		System.out.println("Se va a generar un txt.");
	}
	
	
	@Before("execution(* comprobarTxt())") 
	public void log3() {
		System.out.println("Se va a comprobar si el archivo es un txt.");
	}
		
	@After("execution(* salidaPrograma())") //cualquier generarTxt
	public void log4() {
		System.out.println("Se ha generado el txt correctamente.");
	}
}
