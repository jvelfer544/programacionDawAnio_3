package anio_3.unidad_2;

import java.util.Scanner;

public class ordenaTresNumeros_08 {
	/*
	 * Escribe un programa que ordene tres numeros enteros introducidos por teclado.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Introduce tres números: ");
		System.out.print("primer Número: ");
		int num1 = input.nextInt();

		System.out.print("Segundo Número: ");
		int num2 = input.nextInt();

		System.out.print("Tercer Número: ");
		int num3 = input.nextInt();

		// PRIMERA FORMA:

// Aseguramo que num1 >= num2;

		if (num1 < num2) {
			int aux = num1;
			num1 = num2;
			num2 = aux;
		}

// Aseguramos que num1 >= num3;

		if (num1 < num3) {
			int aux = num1;
			num1 = num3;
			num3 = aux;
		}
		
// Aseguramos que num2 >= num3;
		
		if(num2 < num3) {
			int aux = num2;
			num2 = num3;
			num3 = aux;
		}
		
		System.out.println(num1 + ", " + num2 + ", " + num3);

//		SEGUNDA FORMA:

//		if (num1 >= num2 && num1 >= num3 && num2 >= num3) {
//			System.out.println(num1 + ", " + num2 + ", " + num3);
//
//		} else if (num1 >= num2 && num1 >= num3 && num3 >= num2) {
//			System.out.println(num1 + ", " + num3 + ", " + num2);
//
//		} else if (num2 >= num1 && num2 >= num3 && num1 >= num3) {
//			System.out.println(num2 + ", " + num1 + ", " + num3);
//
//		} else if (num2 >= num1 && num2 >= num3 && num3 >= num1) {
//			System.out.println(num2 + ", " + num3 + ", " + num1);
//
//		} else if (num3 >= num1 && num3 >= num2 && num1 >= num2) {
//			System.out.println(num3 + ", " + num1 + ", " + num2);
//
//		} else {
//			System.out.println(num3 + ", " + num2 + ", " + num1);
//
//		}

		input.close();
	}
}
