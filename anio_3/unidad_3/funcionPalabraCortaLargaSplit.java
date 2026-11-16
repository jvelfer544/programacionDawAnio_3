package anio_3.unidad_3;

import java.util.Scanner;

public class funcionPalabraCortaLargaSplit {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una frase para averiguar que palabra es la mas corta y la mas larga: ");
		String frase = input.nextLine().trim();

		if (frase.isEmpty()) {
			System.out.println("No has introducido ninguna palabra");
		} else {
			String[] palabras = frase.split("\\s+");
			String palabraCorta = corta(palabras);
			String palabraLarga = larga(palabras);
			System.out.println("La palabra mas corta es: " + palabraCorta);
			System.out.println("La palabra mas larga es: " + palabraLarga);
		}

	}

	public static String corta(String[] palabras) {
		String corta = palabras[0];

		for (int i = 1; i < palabras.length; i++) {
			String palabra = palabras[i];
			if (palabra.length() < corta.length()) {
				corta = palabra;
			}
		}

		return corta;
	}

	public static String larga(String[] palabras) {
		String larga = palabras[0];

		for (int i = 1; i < palabras.length; i++) {
			String palabra = palabras[i];
			if (palabra.length() > larga.length()) {
				larga = palabra;
			}
		}

		return larga;
	}

}
