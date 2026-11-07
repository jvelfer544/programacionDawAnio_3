package anio_3.unidad_3;

import java.util.Scanner;

public class esPalindromo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una cadena: ");
		String cadena = input.nextLine().trim().toLowerCase();

		boolean esPalindromo = true;
		int indice = 0;
		
		String cadenaSinEspacios = cadena.replaceAll("\\s+", "");

		while (esPalindromo && indice < cadenaSinEspacios.length() /2) {
			char car = cadenaSinEspacios.charAt(indice);

			if (car != (cadenaSinEspacios.charAt(cadenaSinEspacios.length() -1 -indice))) {
				esPalindromo = false;
				
			}

			indice++;
		}
		
		if(esPalindromo) {
			System.out.println("Si es Palíndromo");
			
		} else {
			System.out.println("No es Palíndromo");
			
		}
	}

}
