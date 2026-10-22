package anio_3.unidad_2;
import java.util.Scanner;

public class ejer_10_numeroUltimaCifra {
/*
 * Escribe un programa que diga cuál es la última cifra de un número entero
 * introducido por teclado.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		
			System.out.println("Introduce un número: ");
			int num = input.nextInt();
			int ultimaCifra = num;
			
				ultimaCifra %= 10;
			
			System.out.println("La última cifra de " + num + " es: " + ultimaCifra);
			
			input.close();
	}

}
