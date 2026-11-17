package anio_3.unidad_3;

import java.util.Scanner;

public class cadenaCumplePatron {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String cadena = input.nextLine();
		System.out.println("Introduce un patrón: ");
		String patron = input.nextLine();
		
		if(utilidadesFunciones.testRegex(cadena, patron)) {
			System.out.println("Cumple con el patrón");
			
		} else {
			System.out.println("No cumple con el patrón");
		}
		
	}
}
