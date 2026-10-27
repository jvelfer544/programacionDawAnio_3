package anio_3.unidad_2;

import java.util.Scanner;

public class ejer01_tareaEntregable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		double precioPeninsula = 5.00;
		double precioBaleares = 9.00;

		System.out.println("Introduzca el peso del paquete en kg: ");
		double peso = input.nextDouble();

		System.out.println("Elija el destino:\n" + " (1: Peninsula \n " + " 2: Baleares/Canarias");
		int destino = input.nextInt();

		double suplementoPeninsula = 1.50;
		double suplementoBaleares = 2.50;
		double total = 0;
		double resto = 0;

		if (destino == 1) {
			if (peso > 5) {
				resto = peso - 5;
				total = precioPeninsula + (suplementoPeninsula * resto);
			} else {
				total = precioPeninsula;
			}
			System.out.println(total + "€");
		} else {

			if (destino == 2 && peso > 5) {
				resto = peso - 5;
				total = precioBaleares + (suplementoBaleares * resto);
				
			} else {
				total = precioPeninsula;
				
			}
			
			System.out.println(total + "€");
		}
	}
}
