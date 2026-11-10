package anio_3.unidad_3;

import java.util.Scanner;

public class fullVocal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce una frase");
		String cadena = input.nextLine().trim();
		String patron = "aeiouáéíóúü";
		boolean vocalEncontrada = true;
		int indice = 0;
		
		while(indice < cadena.length() && vocalEncontrada) {
			char car = cadena.charAt(indice);
			String letra = String.valueOf(car); 
			
			if("a".equalsIgnoreCase(cadena) || "á".equalsIgnoreCase(cadena)) {
				vocalEncontrada = true;
				cadena = cadena.replace("a", "");
				cadena = cadena.replace("á", "");
			} else {
				vocalEncontrada = false;
			}
			
			if("e".equalsIgnoreCase(cadena) || "é".equalsIgnoreCase(cadena)) {
				vocalEncontrada = true;
				cadena = cadena.replace("e", "");
				cadena = cadena.replace("é", "");
			} else {
				vocalEncontrada = false;
			}
			
			if("i".equalsIgnoreCase(cadena) || "í".equalsIgnoreCase(cadena)) {
				vocalEncontrada = true;
				cadena = cadena.replace("i", "");
				cadena = cadena.replace("í", "");
			} else {
				vocalEncontrada = false;
			}
			
			if("o".equalsIgnoreCase(cadena) || "ó".equalsIgnoreCase(cadena)) {
				vocalEncontrada = true;
				cadena = cadena.replace("o", "");
				cadena = cadena.replace("ó", "");
			} else {
				vocalEncontrada = false;
			}
			
			if("u".equalsIgnoreCase(cadena) || "ú".equalsIgnoreCase(cadena) || "ü".equalsIgnoreCase(cadena)) {
				vocalEncontrada = true;
				cadena = cadena.replace("u", "");
				cadena = cadena.replace("ú", "");
				cadena = cadena.replace("ü", "");
			} else {
				vocalEncontrada = false;
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
