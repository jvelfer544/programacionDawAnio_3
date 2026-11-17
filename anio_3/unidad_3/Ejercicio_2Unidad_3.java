package anio_3.unidad_3;

import java.util.Scanner;

public class Ejercicio_2Unidad_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce tu nombre completo con tus dos apellidos: ");
		String nombreCompleto = input.nextLine().trim().replaceAll("\\s+", " ");
		
		String cadenaNueva = "";
		boolean nuevoNombre = true;
		int indice = 0;
		
		while(indice < nombreCompleto.length()) {
			char car = nombreCompleto.charAt(indice);
			
			if(car == ' ') {
				cadenaNueva += car;
				nuevoNombre = true;
				
			} else if (nuevoNombre) {
				cadenaNueva += Character.toUpperCase(car);
				nuevoNombre = false;
				
			} else {
				cadenaNueva += Character.toLowerCase(car);
				
			}
			
			indice++;
		}
		System.out.println(cadenaNueva);
	}

}
