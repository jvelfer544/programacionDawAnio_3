package anio_3.unidad_2;

import java.util.Scanner;

public class calcularTiempoCaerObjeto_3 {
	/*
	 * Realiza un programa que calcule el tiempo que tardará en caer un objeto desde
	 * una altura h. Aplica la formula t=raiz cuadrada de 2*h/g siendo gramos =
	 * 9.81m/s^2
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Introduce la altura en la que quieres dejar caer el objeto: ");
		double altura = input.nextFloat();
		final double GRAVEDAD = 9.81; 
		
		double tiempo = Math.sqrt(((2 * altura) / GRAVEDAD));
		
		System.out.printf("El tiempo que tarda en caer un objeto desde una altura %.2f es de %.2f segundos\n", altura, tiempo);
		
		input.close();
	}
}
