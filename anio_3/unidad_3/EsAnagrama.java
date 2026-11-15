package anio_3.unidad_3;

import java.util.Scanner;

public class EsAnagrama {
	/*
	 * esAnagrama: Verifica si dos cadenas recibidas como parámetro son anagramas
	 * (palabras o frases formadas reorganizando exactamene las mismas letras de
	 * otra, como "amor" y "roma").
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Introduce una primera cadena para ver si es Anagrama con otra cadena: ");
		String cadena1 = input.nextLine();
		System.out.print("Introduce la segunda cadena: ");
		String cadena2 = input.nextLine();

		String cadena1SinEspacios = cadena1.replaceAll("\\s+", "").toLowerCase();
		String cadena2SinEspacios = cadena2.replaceAll("\\s+", "").toLowerCase();

		boolean esAnagrama = true;

		if (cadena1SinEspacios.length() != cadena2SinEspacios.length()) {
			esAnagrama = false;
		}

		int indice = 0;
		
			while (indice < cadena1SinEspacios.length() && esAnagrama) {

				char car1 = cadena1SinEspacios.charAt(indice);
				char car2 = cadena2SinEspacios.charAt(indice);

				String letra1 = String.valueOf(car1);
				String letra2 = String.valueOf(car2);

				if (letra1.matches("[a-záéíóúüñ]") && letra2.matches("[a-záéíóúüñ]")) {
					if (cadena2SinEspacios.indexOf(letra1) != -1) {
						cadena2SinEspacios = cadena2SinEspacios.replaceFirst(letra1, "");
						cadena1SinEspacios = cadena1SinEspacios.replaceFirst(letra2, "");

					} else {
						esAnagrama = false;
					}

				} else {
					esAnagrama = false;

				}

				indice++;
			}
		
		if (esAnagrama) {
			System.out.printf("La cadena %s y %s Si es Anagrama", cadena1, cadena2);
		} else {
			System.out.printf("La cadena %s y %s No es Anagrama", cadena1, cadena2);
		}

	}

}
