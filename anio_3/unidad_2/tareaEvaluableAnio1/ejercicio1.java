package anio_3.unidad_2.tareaEvaluableAnio1;

import java.util.Scanner;

public class ejercicio1 {
	/*
	 * Escribe un programa con una cadena de texto que contenga una contraseña
	 * cualquiera. Después se pedirá al usuario que introduzca la contraseña, con 3
	 * intentos. Cuando acierte mostrará un mensaje de éxito. Si excede el número de
	 * intentos, avisa del error y termina el programa.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		boolean salir = false;
		String contrasena = "3373@Esparta";
		
		int intentos = 3;
		
		do {
			
		System.out.println("Introduce tu contraseña: ");
		String cadena = input.nextLine();
		intentos--;
		
		if(cadena.equals(contrasena)) {
			salir = true;
		} else {
			System.out.printf("Te quedan %d intentos\n", intentos);
		}
		
		if(intentos == 0) {
			salir = true;
		}
		
		} while(intentos > 0 && !salir);
		
		if(salir && intentos != 0) {
			System.out.println("Exito");
		} else {
			System.out.println("La contraseña no es correcta y has gastado los 3 intentos ");
		}
		
		input.close();
	}

}
