package anio_3.unidad_2.tareaEvaluableAnio1;

import java.util.Scanner;

public class ejercicio3 {
	/*
	 * Pedir números positivos al usuario hasta que el usuario introduzca un 0. Al
	 * terminar, mostrará lo siguiente:  mayor número introducido  menor número
	 * introducido  suma de todos los números  media aritmética de todos los
	 * números El número 0 no contara como número introducido
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = 1;
		int aux1 = 0;
		int aux2 = 100;
		boolean salir = false;

		while (num != 0 && !salir) {

			System.out.println("Introduce numeros positivos: (0 para salir)");
			num = input.nextInt();

			if (num == 0) {
				salir = true;
				
			} else {

				if (num > aux1) {
					aux1 = num;
				}

				if (num < aux2) {
					aux2 = num;
				}
			}
		}

		
		System.out.println("El número mayor es: " + aux1);
		System.out.println("El número menor es: " + aux2);
	}

}
