package anio_3.unidad_3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class fullVocalica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce una frase: ");
		String cadena = input.nextLine().trim();
		boolean vocalEncontrada = true;
		
		int indice = 0;
		
		while(indice < cadena.length() && vocalEncontrada) {
			char car = cadena.charAt(indice);
			String letra = String.valueOf(car); 
			
			if("a".equalsIgnoreCase(letra) || "á".equalsIgnoreCase(letra)) {
				vocalEncontrada = true;
				cadena = cadena.replace("a", "");
				cadena = cadena.replace("á", "");
			} 
			
			if("e".equalsIgnoreCase(letra) || "é".equalsIgnoreCase(letra)) {
				vocalEncontrada = true;
				cadena = cadena.replace("e", "");
				cadena = cadena.replace("é", "");
			} 
			
			if("i".equalsIgnoreCase(letra) || "í".equalsIgnoreCase(letra)) {
				vocalEncontrada = true;
				cadena = cadena.replace("i", "");
				cadena = cadena.replace("í", "");
			} 
			
			if("o".equalsIgnoreCase(letra) || "ó".equalsIgnoreCase(letra)) {
				vocalEncontrada = true;
				cadena = cadena.replace("o", "");
				cadena = cadena.replace("ó", "");
			} 
			
			if("u".equalsIgnoreCase(letra) || "ú".equalsIgnoreCase(letra) || "ü".equalsIgnoreCase(letra)) {
				vocalEncontrada = true;
				cadena = cadena.replace("u", "");
				cadena = cadena.replace("ú", "");
				cadena = cadena.replace("ü", "");
			} 
			
			indice++;
		}
		
			if(vocalEncontrada) {
				System.out.println("La cadena Si es fullVocal");
			} else {
				System.out.println("La cadena No es fullVocal");
				
			}
		
	}

}
