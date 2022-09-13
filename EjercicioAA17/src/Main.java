import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static boolean comprobar(long n1, long n2, Comprobar formato) {
		boolean resultado = formato.ejecutar(n1, n2);

		if (resultado == true) {
			System.out.println("Adivinaste, campeón!");
			return resultado;
		} else {
			System.out.println("Sigue probando.");
			return resultado;
		}

	}

	public static void main(String[] args) {
		Comprobar comprobar_num = (long t1, long t2) -> t1 == t2;
		Scanner sc = new Scanner(System.in);
		int nIntentos = 0;
		long n1;
		long n2 = (long) (Math.random() * 1000000 + 1);
		Usuario usuario = new Usuario();

		System.out.print("Como te llamas?: ");
		usuario.nombre = sc.nextLine();
		usuario.fecha = LocalDate.now();

		System.out.println(usuario.toString());
		System.out.println("Tienes 5 intentos. Qué empiece el juego!\n");
		System.out.print("Introduzca el numero a comparar: ");
		n1 = sc.nextLong();

		while (comprobar(n1, n2, comprobar_num) != true && nIntentos < 5) {
			System.out.print("Introduzca el numero a comparar: ");
			n1 = sc.nextLong();
			nIntentos++;
		}
		if (nIntentos == 5) {
			System.out.println("\nOh no! Has perdido... El número a adivinar era " + n2);
			System.out.println("Más suerte la próxima vez.");
		}
		sc.close();
	}

	interface Comprobar {
		boolean ejecutar(long n1, long n2);
	}

}
