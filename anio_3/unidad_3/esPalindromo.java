package anio_3.unidad_3;

import java.util.Scanner;

public class esPalindromo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce una cadena para comprobar si es palíndromo: ");
		String cadena = input.nextLine().trim();
		
		String cadenaInvertida = cadena.replace(" ", "");
		
		
		for(int i=cadena.length()-1; i >= 0; i--) {
	
			char car = cadena.charAt(i);

		}
		System.out.println(cadenaInvertida);
			if(cadena.equalsIgnoreCase(cadenaInvertida)) {
				System.out.println("Si es Palíndromo");
			} else {
				System.out.println("No es Palíndromo");
			}
		
		
	}

}
