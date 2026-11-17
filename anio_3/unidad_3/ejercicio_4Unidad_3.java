package anio_3.unidad_3;

import java.util.Scanner;

public class ejercicio_4Unidad_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/*
		 *  a) validar DNI
		 */
		
//		System.out.println("Introduce tú DNI con la Letra: ");
//		String dni = input.nextLine();
//		
//		if(utilidadesFunciones.validarDni(dni)) {
//		System.out.println("Si");
//		} else {
//			System.out.println("No");
//		}
		
		// b) Validar código postal
		
		System.out.println("Introduce el código postal: ");
		String codigoPostal = input.nextLine();
		
		if(utilidadesFunciones.esCodigoPostal(codigoPostal)) {
			
		}
	}
}
