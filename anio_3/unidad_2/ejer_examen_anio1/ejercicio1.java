package anio_3.unidad_2.ejer_examen_anio1;

import java.util.Scanner;

public class ejercicio1 {
	/*
	 * Realizar un programa que muestre en pantalla el siguiente menú:
	 * ----------------| Grado D. CFGS DAW |-------------- | | 1 – Módulo de
	 * Lenguaje de Marcas | | 2 – Módulo de Programación | | 0 – Resumen y salir | |
	 * -----------------------------------------  Posteriormente se debe quedar a
	 * la espera de que el usuario introduzca un valor numérico.  Si se introduce
	 * la opción 1 o 2, solicitará un valor con decimales. Dicho valor será guardado
	 * en la nota del módulo correspondiente y volverá a mostrar el menú. La nota
	 * debe tener un valor comprendido entre 0 y 10, ambos incluidos.  Si introduce
	 * un 0 el programa mostrará un mensaje mostrando las calificaciones de cada uno
	 * de los módulos y finalizará.  Si no se ha introducido valor para alguna nota
	 * se mostrará “NOEV” para dicho módulo.  Si para un módulo se introducen
	 * varias notas, quedará la última introducida. Ejemplo:
	 * ______________________________________ | Calificaciones DAW | | Módulo de
	 * Programación: 5,7 | | Módulo de Lenguaje de Marcas: NOEV |
	 * |____________________________________|
	 *
	 *  Si se introduce cualquier otra opción distinta a 0, 1 o 2, el programa
	 * mostrará un mensaje de error y volverá al menú.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		boolean salir = false;
		double lm = -1;
		double prog = -1;

		while (!salir) {
			System.out.println("---------------| Grado D. CFGS DAW |---------------\n"
					+ "| 1 - Módulo de Lenguaje de Marcas                |\n"
					+ "| 2 - Módulo de Programación                      |\n"
					+ "| 0 - Resumen y salir                             |\n"
					+ "---------------------------------------------------\n");

			System.out.print("Introduce una opción: ");
			int numero = input.nextInt();

			if (numero == 1 || numero == 2) {

				if (numero == 1) {
					System.out.println("Introduce la nota de Lenguaje de Marcas:");
					double aux = input.nextDouble();

					if (aux < 0 || aux > 10) {
						System.out.println("La nota introducida no es correcta");

					} else {
						lm = aux;

					}

				} else if (numero == 2) {
					System.out.println("Introduce la nota de Programación:");
					double aux = input.nextDouble();

					if (aux < 0 || aux > 10) {
						System.out.println("La nota introducida no es correcta");

					} else {
						prog = aux;

					}
				}

			} else if (numero == 0) {
				salir = true;

			} else {
				System.out.println("ERRORRR, esa opción no es válida\n");

			}

		}

		String resulLm = (lm == -1) ? "NOEV" : String.valueOf(lm);
		String resulProg = (prog == -1) ? "NOEV" : String.valueOf(prog);
		
		System.out.println("--------------------------------------\n"
				+ "| Calificación DAW                     	  	 |\n"
				+ "| Módulo de Programación: " + resulProg +"    |\n"
				+ "| Módulo de Lenguaje de Marcas: " + resulLm +"|\n"
			    + "-X----------------------------------------------");
		
		input.close();
	}
}
