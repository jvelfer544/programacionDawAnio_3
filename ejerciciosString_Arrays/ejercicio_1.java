package ejerciciosString_Arrays;

import java.util.Scanner;

public class ejercicio_1 {
	/*
	 * Crea una biblioteca de funciones para cadenas de texto que contenga las
	 * siguientes funciones. Puedes usar métodos de la clase String y de la clase de
	 * utilidades StringUtils de apache.
	 * 
	 * d) invertirCadena: Este método debería invertir el orden de los caracteres en
	 * una cadena, de modo que el primer carácter se convierta en el último y
	 * viceversa.
	 * 
	 * g) esAnagrama: Un anagrama es una palabra o frase formada reorganizando las
	 * letras de otra. Este método debería verificar si dos cadenas son anagramas.
	 * 
	 * j) reemplazarCaracter: Reemplazaría todas las ocurrencias de un carácter
	 * específico por otro en la cadena.
	 * 
	 * k) esNumero: Verificaría si una cadena representa un número. Esto podría
	 * implicar comprobar si todos los caracteres en la cadena son dígitos.
	 */
	public static void main(String[] args) {
		/*
		 * A) esPalindromo: Este método debería verificar si una cadena es un
		 * palíndromo, lo que significa que la cadena se lee igual de izquierda a
		 * derecha que de derecha a izquierda.
		 */

		Scanner input = new Scanner(System.in);

		System.out.print("Inserta una cadena para comprobar si es Palíndromo: ");
		String cadena = input.nextLine().trim().toLowerCase();

		String cadenaInvertida = "";

		// PRIMERA FORMA:
//		for(int i=cadena.length()-1; i >= 0;i--) {
//			char car = cadena.charAt(i);
//			cadenaNueva += car;
//		}

		// SEGUNDA FORMA:
// Crea un objeto de la clase especial StringBuilder 
		cadenaInvertida = new StringBuilder(cadena).reverse().toString();
// .toString() usamos este comando final para volver a convertirlo en un texto normal (String) y poder guardarlo en tu variable.

		if (cadenaInvertida.equals(cadena)) {
			System.out.print("Si es palindromo");

		} else {
			System.out.println("No es Palíndromo");

		}

		/*
		 * B) esHeterograma: Un heterograma es una palabra o frase en la que no se
		 * repiten las letras. Este método debería comprobar si una cadena es un
		 * heterograma.
		 */

		/*
		 * C) conteoVocales: Debería contar el número de vocales en una cadena,
		 * proporcionando así la cantidad total de letras 'a', 'e', 'i', 'o' y 'u'.
		 * Extra: Incluye las vocales acentuadas en español.
		 */
		String vocales = "aeiouáéíóú";

		int contadorVocales = 0;

		for (int i = 0; i < cadena.length(); i++) {
			char car = cadena.charAt(i);

			/*
			 * Si encuentra lo que buscas, detiene la búsqueda y devuelve el número de esa
			 * posición. Si revisa todo el texto y no encuentra nada, siempre devuelve el
			 * valor -1.
			 */
			if (vocales.indexOf(car) != -1) {
				contadorVocales++;
			}

		}

		System.out.println("El número de vocales es " + contadorVocales);

		/*
		 * E) eliminarEspacios: Eliminaría todos los espacios en blanco de una cadena,
		 * devolviendo una versión de la cadena sin espacios.
		 */
		// PRIMERA FORMA:
		String nuevaCadena = "";
//		for(int i=0; i < cadena.length();i++) {
//			char car = cadena.charAt(i);
//			if(car != ' ') {
//				nuevaCadena += car;
//			}
//		}
		// SEGUNDA FORMA:
		nuevaCadena = cadena.replaceAll("\\s+ ", "");

		System.out.println(nuevaCadena);

		/*
		 * f) eliminarEspaciosDuplicados: Eliminaría todos los espacios repetidos que
		 * haya entre dos palabras, devolviendo una versión de la cadena con sus
		 * palabras separadas con un solo espacio.
		 */

		nuevaCadena = cadena.replaceAll("\\s+", " ");

		System.out.println(nuevaCadena);

		/*
		 * h) contarPalabras: Contaría el número de palabras en una cadena. Esto podría
		 * hacerse contando los espacios entre las palabras.
		 */
		String cadena1 = cadena.replaceAll("\\s+", " ");

		int contadorPalabras = 1;

		for (int i = 0; i < cadena1.length(); i++) {
			char car = cadena1.charAt(i);

			if (car == ' ') {
				contadorPalabras++;
			}
		}
		System.out.println("El número de palabras es: " + contadorPalabras);

		/*
		 * i) mayusculasMinusculas: Dependiendo de un parámetro booleano, este método
		 * convertiría la cadena a mayúsculas o minúsculas o viceversa.
		 */

		System.out.println("Introduce mayúsculas o minúsculas");
		String tipo = input.nextLine().trim().toLowerCase();

		boolean mayusculas = false;
		boolean opcionValida = true;
		 
		if(tipo.equals("mayusculas") || tipo.equals("mayúsculas")) {
			mayusculas = true;
			
		} else if (tipo.equals("minusculas") || tipo.equals("minúsculas")) {
			mayusculas = false;
			
		} else {
			System.out.println("El dato introducido no es el correcto");
			opcionValida = false;
			
		}

		if (opcionValida) {
		 String resultado = mayusculas ? cadena.toUpperCase() : cadena.toLowerCase();
		 System.out.println(resultado);
		 
		}

		input.close();
	}
}
