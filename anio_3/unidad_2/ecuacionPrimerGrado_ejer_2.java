package anio_3.unidad_2;

import java.util.Scanner;

public class ecuacionPrimerGrado_ejer_2 {
	/*
	 * Realiza un programa que resuelva una ecuación de primer grado (del tipo
	 * ax+b=0. Ejemplo 1: Este programa resuelve ecuaciones de primer grado del tipo
	 * ax + b = 0 Por favor, introduzca el valor de b: 1 x = -0.5 Ejmeplo 2
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Introduce el valor de a: ");
		float a = input.nextFloat();

		System.out.print("Introduce el valor de b: ");
		float b = input.nextFloat();

		float resultado;

		input.close();

		resultado = -b / a;

		if (a == 0) {
			System.out.println("Esa ecuación no tiene solución ");

		} else {

			System.out.println("El valor de x es " + resultado);
		}

	}

}
