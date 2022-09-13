package spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class AspectoLog {
	@After("execution(* generarTxt())") 
	public void log1() {
		System.out.println("Se han generado los txts.");
	}

}
