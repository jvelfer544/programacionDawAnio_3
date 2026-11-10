package anio_3.unidad_3;

import java.util.Scanner;

public class PalabraLargaCortaCaracteres {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce una frase para ver la palabra más corta y la más larga");
		String frase = scan.nextLine();
		scan.close();
		String larga = "";
		String corta = "";
		String palabraAux = "";
		
		for (char caracter : frase.toCharArray()) {
			
			if (caracter == ' ' && !palabraAux.isBlank()) {
				
				if (palabraAux.length() > larga.length()) {
					larga = palabraAux;
					
				}else if (palabraAux.length() < corta.length()) {
					corta = palabraAux;
					
				}
				
				palabraAux = "";
				
			} else {
				palabraAux += caracter;
				
			}
			
		}
		
		System.out.println("La palabra más larga de la frase es " + larga);
		System.out.println("y la palabra más corta de la frase es " + corta);
	}

}
