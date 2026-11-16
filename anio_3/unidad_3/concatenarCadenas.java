package anio_3.unidad_3;

import java.util.Scanner;

public class concatenarCadenas {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una cadena: ");
		String cadena1 = input.nextLine();
		System.out.print("Introduce otra cadena: ");
		String cadena2 = input.nextLine();
		input.close();
		System.out.println(utilidadesFunciones.concatenaCadenas(cadena1, cadena2));
		
	}

}
