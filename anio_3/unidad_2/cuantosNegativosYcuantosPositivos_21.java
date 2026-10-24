package anio_3.unidad_2;

import java.util.Scanner;

public class cuantosNegativosYcuantosPositivos_21 {
	/*
	 * Escribe un programa que lea una lista de diez númeos y determine cuántos son
	 * positivos, y cuantos son negativos.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int contadorPositivo = 0;
		int contadorNegativo = 0;

		System.out.println("Introduce una lista de diez números: ");

		int i = 1;

		do {
			System.out.println("numero " + i + ": ");
			int numeros = input.nextInt();
			i++;

			if (numeros < 0) {
				contadorNegativo++;
				
			} else if (numeros > 0) {
				contadorPositivo++;
			} 

		} while (i <= 10);

		System.out.println("Números positivos: " + contadorPositivo);
		System.out.println("Números negativos: " + contadorNegativo);
		
		input.close();
	}
}
