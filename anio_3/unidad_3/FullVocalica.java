package anio_3.unidad_3;

import java.util.Scanner;

public class FullVocalica {
/*
 * esFullVocalica: 
 * Devuelve si aparecen todas las vocales en una cadena,
 * incluyendo tanto mayúsculas y minúsculas como vocales acentuadas en español
 * a -> a, á, A, Á
 * u -> u, ü, ú, U, Ú, Ü
 */
	public static void main(String[] args) {
				
				Scanner scan = new Scanner(System.in);
				System.out.println("Introduce una frase para comprobar si es full vocálica");
				String frase = scan.nextLine().trim().toLowerCase();
				
				int indice = 0;
				boolean encontradoA = false;
				boolean encontradoE = false;
				boolean encontradoI = false;
				boolean encontradoO = false;
				boolean encontradoU = false;
				
				String patronVocales = "[AEIOUÁÉÍÓÚÜ]";
				
				while (indice < frase.length() && (!encontradoA || !encontradoE || !encontradoI 
						|| !encontradoO || !encontradoU)) {
					String letra = String.valueOf(frase.charAt(indice));
					
					if (letra.matches(patronVocales)) {
						if (letra.matches("[EÉ]")) {
							encontradoE = true;
							patronVocales = patronVocales.replace("E", "");
							patronVocales = patronVocales.replace("É", "");
						} else if (letra.matches("[AÁ]")) {
							encontradoA = true;
						} else if (letra.matches("[OÓ]")) {
							encontradoO = true;
						} else if (letra.matches("[IÍ]")) {
							encontradoI = true;
						}else if (letra.matches("[UÚÜ]")) {
							encontradoU = true;
						}
					}
					indice++;
				}
				
				if(encontradoA && encontradoE && encontradoI && encontradoO && encontradoU) {
					System.out.println("Si es fullVocalica");
				} else {
					System.out.println("No es fullVocalica");
				}
	}

}
