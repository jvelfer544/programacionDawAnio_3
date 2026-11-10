package anio_3.unidad_3;

import java.util.Scanner;

public class PalabraLargaCorta {

	public static void main(String[] args) {
		
		System.out.println("Introduce una frase para ver la palabra más corta y la más larga");
		Scanner scan = new Scanner(System.in);
		String frase = scan.nextLine();
		scan.close();
		
		String[] palabras = frase.split(" ");
		
		String larga = palabras[0];
		String corta = palabras[0];
		
		for (int posicion = 1; posicion < palabras.length; posicion++) {
			String palabra = palabras[posicion];
			
			if (palabra.length() > larga.length()) {
				larga = palabra;
				
			}else if (palabra.length() < corta.length()) {
				corta = palabra;
			}
		}
		
		System.out.println("La palabra más larga de la frase es " + larga);
		System.out.println("y la palabra más corta de la frase es " + corta);
	}

}
