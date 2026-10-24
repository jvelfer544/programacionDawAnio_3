package anio_3.unidad_2.ejercicios_tarea_clase;

import java.util.Scanner;

public class ejer01_tareaEntregable {
	/*
	 * Una empresa de mensajería calcula el coste del envío de un paquete según su
	 * peso y el destino elegido. Escribe un programa que pida por teclado el peso
	 * del paquete en kilogramos (un valor real) y el destino (1: Península, 2:
	 * Baleares o Canarias). Se supone entrada del usuario correcta, no hay que
	 * validar los datos de entrada. El precio se calcula según las siguientes
	 * reglas: -Península: El precio base es de 5,00 €. Si el paquete pesa más de 5
	 * kg, se cobra un suplemento de 1,50 € por cada kilogramo total, no se tienen
	 * en cuenta las fracciones de kilogramo. -Baleares o Canarias: El precio base
	 * es de 9,00 €. Si el paquete pesa más de 5 kg, el suplemento es de 2,50 € por
	 * cada kilogramo total.
	 * 
	 * Ejemplo 1: Introduzca el peso del paquete en kg: 3.5 Elija el destino (1:
	 * Península, 2: Baleares/Canarias): 1 El coste total del envío es de 5.00
	 * euros.
	 * 
	 * Ejemplo 2: Introduzca el peso del paquete en kg: 8.2 Elija el destino (1:
	 * Península, 2: Baleares/Canarias): 2 El coste total del envío es de 29.00
	 * euros.
	 */
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
				resto = (int) peso - 5;
				total = precioPeninsula + (suplementoPeninsula * resto);
			} else {
				total = precioPeninsula;
			}
			System.out.println(total + "€");

		} else if (destino == 2) {

			if (peso > 5) {
				resto = (int) peso - 5;
				total = precioBaleares + (suplementoBaleares * resto);

			} else {
				total = precioPeninsula;

			}

			System.out.println(total + "€");
		}
	}
}
