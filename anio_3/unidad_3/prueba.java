package anio_3.unidad_3;

import java.util.Scanner;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String frase = input.nextLine().trim().toLowerCase();
		boolean esHeterograma = true;
		
		String abecedario = "[a-zñáéíóúü]";
		String fraseSinEspacios = frase.replaceAll("\\s+","");
		int indice = 0;
		
		while(indice < fraseSinEspacios.length() && esHeterograma) {
			
			char car = fraseSinEspacios.charAt(indice);
			String letra = String.valueOf(car);
			
			if(letra.indexOf(fraseSinEspacios)) {
				
			}
			
			indice++;
		}
		

	}
}
