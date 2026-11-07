package anio_3.unidad_2;
import java.util.Scanner;

public class ejer11_primeraCifra {
/*
 * Escribe un programa que diga cuál es la primera cifra de un número entero introducido
 * por teclado. Se permiten números de hasta 5 cifras.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner (System.in);

		System.out.print("Introduce un número de hasta 5 cifras: ");
		int num = input.nextInt();
		
		int primeraCifra = num;
		
		while(primeraCifra >= 10) {
			
			primeraCifra /= 10;
		}
		
		System.out.println(primeraCifra);
		
		input.close();
	}

}
