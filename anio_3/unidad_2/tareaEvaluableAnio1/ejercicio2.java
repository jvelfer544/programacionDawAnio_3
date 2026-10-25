package anio_3.unidad_2.tareaEvaluableAnio1;

import java.util.Scanner;

public class ejercicio2 {
	/*
	 * Realizar un programa que muestre en pantalla el siguiente menú:
	 * ~~~~~~~~~~~~| CALCULADORA |~~~~~~~~~~~ 
	 * 1 - Suma 
	 * 2 - Resta 
	 * 3 - Multiplicación 
	 * 4 – División 
	 * 5 - Raíz cuadrada 
	 * 6 – Potencia 
	 * 0 - Salir delprograma 
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * Posteriormente se quedará a
	 * la espera de que el usuario introduzca un valor numérico. Si introduce un 0
	 * el programa mostrará un mensaje de despedida, que habrá que confirmar
	 * pulsando cualquier tecla y después finalizará. Si se pulsa un valor
	 * comprendido entre 1 y 6 pedirá al usuario dos números y devolverá el
	 * resultado de la operación escogida. Si se pulsa cualquier otra cosa el
	 * programa volverá a mostrar el menú tras un mensaje de error instando a
	 * introducir un valor correcto.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);


		int num1 = 0;
		int num2 = -1;

		int opcion = -1;
		int resultado = 0;
		boolean salir = false;

		while (!salir) {
			
				System.out.println("~~~~~| CALCULADORA |~~~~~\n" + "1 - Suma\n" + "2 - Resta\n"
						+ "3 - Multiplicación\n" + "4 - División\n" + "5 - Raíz cuadrada\n" + "6 - Potencia\n"
						+ "0 - Salir del programa\n");
				
				System.out.print("Introduce una opción: ");
				opcion = input.nextInt();
				
			if (opcion == 5) {
				
				
				System.out.print("Introduce un número: ");
				num1 = input.nextInt();
				
			} else if (opcion > 0 && opcion <= 6) {
				System.out.print("Introduce un primer número: ");
				num1 = input.nextInt();
				
				System.out.print("Introduce el segundo número: ");
				num2 = input.nextInt();
				
			}

			switch (opcion) {
			case 1:
				resultado = num1 + num2;
				break;

			case 2:
				resultado = num1 - num2;
				break;

			case 3:
				resultado = num1 * num2;
				break;

			case 4:
				if (num2 != 0) {
					resultado = num1 / num2;
				} else {
					System.out.println("No se puede dividir entre 0");
				}
				break;

			case 5:
				resultado = (int) Math.sqrt(num1);

				break;

			case 6:
				resultado = (int) Math.pow(num1, num2);
				break;

			case 0:
				System.out.println("Saliendo del Programa");
				input.next();
				salir = true;
				break;

			default:
				System.out.println("La opción introducida no es válida");
				break;
			}
			
			if (opcion > 0 && opcion <= 6 && !(opcion == 4 && num2 == 0)) {
				
				System.out.println("El resultado es: " + resultado);
			
			}
		}

		input.close();
	}

}
