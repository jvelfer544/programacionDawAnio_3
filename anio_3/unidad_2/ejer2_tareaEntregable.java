package anio_3.unidad_2;

import java.util.Scanner;

public class ejer2_tareaEntregable {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Introduce un número para la tabla de multiplicar: ");
		int numero = input.nextInt();

		for (int i = 10; i >= 0; i--) {
			
			int resultado = numero * i;
			System.out.println(numero + " x " + i + "= " + resultado);
		}

		input.close();
	}
}