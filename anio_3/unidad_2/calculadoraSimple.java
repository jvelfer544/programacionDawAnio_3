package anio_3.unidad_2;

import java.util.Scanner;

public class calculadoraSimple {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.println("***CALCULADORA***");
		System.out.println("1. Sumar\n" + "2. Restar\n" + "3. Multiplicar\n" + "4. Dividir\n" + "0. Salir\n");

		int resultado = 0;
		double division = 0;

		boolean salir = false;

		while (!salir) {
			System.out.println("Elige la opcion: ");
			int menu = input.nextInt();
			
			if (menu == 0) {
				salir = true;

			} else {

				if (menu == 1) {
					System.out.print("Introduce el primer número: ");
					int num1 = input.nextInt();
					System.out.print("Introduce el segundo número: ");
					int num2 = input.nextInt();
					resultado = num1 + num2;

				} else if (menu == 2) {
					System.out.print("Introduce el primer número: ");
					int num1 = input.nextInt();
					System.out.print("Introduce el segundo número: ");
					int num2 = input.nextInt();
					resultado = num1 - num2;

				} else if (menu == 3) {
					System.out.print("Introduce el primer número: ");
					int num1 = input.nextInt();
					System.out.print("Introduce el segundo número: ");
					int num2 = input.nextInt();
					resultado = num1 * num2;

				} else {
					System.out.print("Introduce el primer número: ");
					double num1 = input.nextInt();
					System.out.print("Introduce el segundo número: ");
					double num2 = input.nextInt();

					if (num2 == 0) {
						System.out.println("No se puede dividir por cero");
					} else {
						division = num1 / num2;
					}

				}

			}

			if (salir) {
				System.out.println("Saliendooooo");

			} else {

				if (menu == 4) {
					System.out.println(division);
				} else {
					System.out.println(resultado);

				}
			}
		}
	}
}
