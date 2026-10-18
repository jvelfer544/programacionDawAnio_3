package anio_3.unidad_2;

import java.util.Scanner;

public class numeroCapicua {
	/*
	 * Escribe un programa que diga si el número es capicua
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce un numero de dos digitos para ver si es capicuo: ");
		int numOriginal = input.nextInt();
		input.close();

		int num = numOriginal;
		int invertido = 0;
		int ultimaCifra = 0;
		while(num > 0) {
			ultimaCifra = num % 10;
			invertido = (invertido * 10) + ultimaCifra;
			
			num /= 10;
		}

		if (invertido == numOriginal) {
			System.out.println("El número " + numOriginal + " Si es capicua");

		} else {
			System.out.println("El número " + numOriginal + " No es capicua");

		}
	}

}
