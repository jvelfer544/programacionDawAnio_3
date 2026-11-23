package anio_3.unidad_3;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class tarea2PracticaEjer2_Sol_Profesor {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un texto");
		// Obtiene la cadena del usuario
		String texto = input.nextLine();
		
//		a) Limpieza del texto: Elimina signos de puntuación (puntos, comas,
//				puntos y comas, dos puntos) mediante expresiones regulares con
//				StringUtils.replaceAll. --> StringUtils.replaceChars
		String textoLimpio = StringUtils.replaceChars(texto.trim(), ".,;:", " ");
		System.out.println("texto limpio:\n" + textoLimpio);
		
//				b) Tokenización: Divide el texto en un array de palabras individuales
//				mediante Split.
		String[] tokens = textoLimpio.split(" ");
		
//				c) Palabra más larga y la más corta: Determina la palabra con mayor
//				número de caracteres y la de menor longitud del texto.
		String larga = tokens[0];
		String corta = tokens[0];
		
		for (String palabra : tokens) {
			if (palabra.length() > larga.length()) {
				larga = palabra;
			}else if (palabra.length() < corta.length()) {
				corta = palabra;
			}
		}
		System.out.println("La palabra más larga es " + larga);
		System.out.println("La palabra más corta es " + corta);
		
//				d) Búsqueda de frecuencia: Pide al usuario una palabra concreta y cuenta
//				cuántas veces aparece repetida en el texto sin distinguir mayúsculas de
//				minúsculas usa StringUtils.countMatches.
		String palabraBusqueda = input.nextLine();
		int count = StringUtils.countMatches(textoLimpio.toLowerCase(), palabraBusqueda.toLowerCase());
		System.out.println("La palabra " + palabraBusqueda + " aparece " + count + " veces en el texto.");

	}

}
