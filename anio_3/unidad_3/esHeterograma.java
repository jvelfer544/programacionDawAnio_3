package anio_3.unidad_3;

import java.util.Scanner;

public class esHeterograma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una cadena: ");
		String cadena = input.nextLine().trim().toLowerCase();
		
		boolean esHeterograma = true;
		String cadenaDistinta = "";
		int indice = 0;

		while (indice < cadena.length() && esHeterograma) {
			char car = cadena.charAt(indice);

			//String letra = "" + car;
			String letra = String.valueOf(car);

			if (letra.matches("[a-zñáéíóü]")) {
				
				if (cadenaDistinta.indexOf(letra) == -1) {
					cadenaDistinta += letra;
					
				} else {
					esHeterograma = false;

				}
			}

			indice++;
		}

		if (esHeterograma) {
			System.out.println("Si es heterograma");

		} else {
			System.out.println("No es heterograma");

		}

		input.close();
	}

}
