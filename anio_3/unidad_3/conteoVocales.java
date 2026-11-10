package anio_3.unidad_3;

import java.util.Scanner;

public class conteoVocales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.println("Introduce una cadena para contar las vocales: ");
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
			System.out.println("El número de vocales es " + contador);
		} else {
			System.out.println("La cadena introducida no tiene vocales");
		}
	}
}
