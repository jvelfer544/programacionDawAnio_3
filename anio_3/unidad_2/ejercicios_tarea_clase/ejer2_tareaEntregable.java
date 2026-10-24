package anio_3.unidad_2.ejercicios_tarea_clase;

import java.util.Scanner;

public class ejer2_tareaEntregable {
/*
 * Escribe un programa que muestre la tabla de multiplicar de un número entero introducido por teclado, pero mostrándola en orden inverso (desde el 10 hasta el 0).
No validar la entrada del usuario.
Ejemplo:
Por favor, introduzca un número entero: 7
Tabla de multiplicar del 7 (en orden inverso):
7 x 10 = 70
7 x 9 = 63
7 x 8 = 56
7 x 7 = 49
7 x 6 = 42
7 x 5 = 35
7 x 4 = 28
7 x 3 = 21
7 x 2 = 14
7 x 1 = 7
7 x 0 = 0
Nota: respeta el formato del ejemplo.
 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Introduce un número para la tabla de multiplicar: ");
		int numero = input.nextInt();

		System.out.printf("Tabla de multiplicar del %d (en orden inverso:)\n", numero);

		for (int i = 10; i >= 0; i--) {	
			int resultado = numero * i;
			System.out.printf("%d x %d = %d \n", numero, i, resultado);
		}

		input.close();
	}
}