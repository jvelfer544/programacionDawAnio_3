package anio_3.unidad_3;

import java.util.Scanner;

public class PalabraCortaLargaSplit {

	public static void main(String[] args) {
		
		System.out.println("Introduce una frase para ver la palabra más corta y la más larga");
		Scanner scan = new Scanner(System.in);
		String frase = scan.nextLine();
		scan.close();
		
		String[] palabras = frase.split("\\s+");
		
		String larga = palabras[0];
		String corta = palabras[0];
		
		for (int i = 1; i < palabras.length; i++) {
			String palabra = palabras[i];
			
			if (palabra.length() > larga.length()) {
				larga = palabra;
				
			} else if (palabra.length() < corta.length()) {
				corta = palabra;
				
			}
		}
		
		System.out.println("La palabra más larga de la frase es " + larga);
		System.out.println("y la palabra más corta de la frase es " + corta);
	}

}
