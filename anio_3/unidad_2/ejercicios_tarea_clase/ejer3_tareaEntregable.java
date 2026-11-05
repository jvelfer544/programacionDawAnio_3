package anio_3.unidad_2.ejercicios_tarea_clase;

import java.util.Scanner;

public class ejer3_tareaEntregable {
/*
 * Realiza un programa que vaya pidiendo por teclado números enteros para calcular su suma total. 
 * La lectura de datos finalizará cuando el usuario introduzca un número negativo. El programa mostrará 
 * la cantidad de números válidos introducidos(sin contar el negativo ni los ceros) y la suma total 
 * acumulada (sin incluir el número negativo que provocó el fin).

Ejemplo 1:
Introduzca un número entero (número negativo para salir): 12
Introduzca un número entero (número negativo para salir): 0
Introduzca un número entero (número negativo para salir): 8
Introduzca un número entero (número negativo para salir): -1

Ha introducido 2 números válidos.
La suma total acumulada es: 20

Ejemplo 2:
Introduzca un número entero (número negativo para salir): -5

Ha introducido 0 números válidos.
La suma total acumulada es: 0
Respeta el formato mostrado en los ejemplos.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int suma = 0;
		int num = 0;
		boolean salir = false;
		int contador = 0;

		do {
			
			System.out.print("Introduzca un número entero (número negativo para salir): ");
			num = input.nextInt();

			if (num < 0) {
				salir = true;
			}

			if (num > 0) {
				suma += num;
				contador++;
			}

		} while (num >= 0 && !salir);

		System.out.printf("Ha introducido %d número válidos.\n", contador);
		System.out.println("La suma total acumulada es: " + suma);
		
		input.close();
	}

}
