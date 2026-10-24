package anio_3.unidad_2;

import java.util.Scanner;

public class ejer9_triangulo {
	/*
	 * Escribe un programa que pinte una pirámide rellena con un carácter
	 * introducido por teclado que podrá ser una letra, un número o los símbolos
	 * como *, +, € o $. El programa debe permitir al usuario mediante un menú
	 * elegir si el vértice de la pirámide está apuntando hacia arriba, hacia abajo
	 * o hacia la derecha.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce la longitud del triangulo: ");
		int longitud = input.nextInt();

		input.nextLine(); // Actúa como purga para tragar el 'Enter' sobrante
		
		System.out.print("Introduce una letra o el carácter *, +, € o $: ");
		String caracter = input.nextLine();

		char car;

		if (caracter.length() == 1) {
			car = caracter.charAt(0);
		} else {
			car = '@';
		}

		if ((car >= 'A' && car <= 'Z') || (car >= 'a' && car <= 'z') || car == '*' || car == '+' || car == '€'
				|| car == '$') {

			for (int i = 0; i < longitud; i++) {

				for (int j = 0; j <= i; j++) {
					System.out.print(car + " ");

				}

				System.out.println();
			}
		} else {
			System.out.println("El carácter introducido no es válido ");
		}
	}

}
