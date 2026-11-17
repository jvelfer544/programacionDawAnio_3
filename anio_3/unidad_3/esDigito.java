package anio_3.unidad_3;

import java.util.Scanner;

public class esDigito {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String digito = input.nextLine();
		
		if(utilidadesFunciones.esDigito(digito)) {
			System.out.println("Cumple con el patrón");
			
		} else {
			System.out.println("No cumple con el patrón");
		}
	}

}
