package anio_3.unidad_3;

import java.util.Scanner;

public class conteoVocales {
	/*
	 * 
	 * c) conteoVocales: Cuenta y devuelve el número total de vocales en una cadena,
	 * incluyendo tanto mayúsculas y minúsculas como vocales acentuadas en español
	 * (á, é, í, ó, ú, ü).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce un cadena: ");
		String cadena = input.nextLine().trim().toLowerCase();

		int contador = 0;

		for (int i = 0; i < cadena.length(); i++) {
			char car = cadena.charAt(i);

			String letra = String.valueOf(car);

			if (letra.matches("[aeiouáéíóúü]")) {
				contador++;

			}
		}

		if (contador > 0) {
			System.out.println("El número de vocales es: " + contador);

		} else {

			System.out.println("No hay vocales en la cadena " + cadena);
		}
	}

}
