package tema2;

import java.util.Scanner;

public class numeroCapicua {
	/*
	 * Escribe un programa que dia si el número es capicua
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce un numero de dos digitos para ver si es capicuo: ");
		int numero = input.nextInt();
		input.close();

		int ultimaCifra = numero % 10;
		int primeraCifra = numero / 10;


		if (primeraCifra == ultimaCifra) {
			System.out.println("El número " + numero + " Si es capicua");

		} else {
			System.out.println("El número " + numero + " No es capicua");

		}

	}

}
