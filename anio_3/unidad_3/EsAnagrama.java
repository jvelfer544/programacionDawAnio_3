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

		System.out.println("Introduce un primera cadena para ver si es anagrama con la segunda: ");
		String cadena1 = input.nextLine();

		System.out.println("Introduce la segunda cadena: ");
		String cadena2 = input.nextLine();

		String cadena1SinEspacios = cadena1.replaceAll("\\s+", "").toLowerCase();
		String cadena2SinEspacios = cadena2.replaceAll("\\s+", "").toLowerCase();

		int indice = 0;
		
		boolean esAnagrama = true;

		if (cadena1SinEspacios.length() != cadena2SinEspacios.length()) {
			System.out.println("No es anagrama");

		} else {
			while (indice < cadena1SinEspacios.length() && esAnagrama) {
				char car = cadena1SinEspacios.charAt(indice);

				String letra = String.valueOf(car);
				indice++;

				// if (cadena2SinEspacios.contains(String.valueOf(car)))
				if (cadena2SinEspacios.indexOf(letra) != -1) {
					cadena2SinEspacios = cadena2SinEspacios.replaceFirst(letra, "");
					
				} else {
					esAnagrama = false;
				}
			}
			
				if(esAnagrama) {
					System.out.printf("Las siguientes frases y palabras Si es Anagrama \n%s y %s", cadena1, cadena2);
				} else {
					System.out.printf("Las siguientes frases y palabras No es Anagrama \n%s y %s", cadena1,cadena2);
				}

		}

	}

}
