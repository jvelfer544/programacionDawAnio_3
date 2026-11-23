package anio_3.unidad_3;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class tarea2PracitaEjer2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String cadena = input.nextLine();
		
		String patron = ".,;:";
		String cadenaNueva = "";
		
		// StringUtils.replaceChars()
		cadenaNueva += StringUtils.replaceChars(cadena, patron, "");

		if (cadena.isBlank()) {
			System.out.println("La cadena está vacía");
		} else {

			System.out.println(cadenaNueva);

			String palabras[] = cadenaNueva.trim().split("\\s+");
			String palabraLarga = palabras[0];
			String palabraCorta = palabras[0];
			String palabra = "";

			for (int i = 0; i < palabras.length; i++) {
				palabra = palabras[i];

				if (palabra.length() < palabraCorta.length()) {
					palabraCorta = palabra;

				} else if (palabra.length() > palabraLarga.length()) {
					palabraLarga = palabra;

				}
			}
			
		if (palabraCorta.length() == palabraLarga.length()) {
			System.out.println("La palabra más corta y la palabra más larga son iguales");

		} else {
			System.out.println("La palabra más corta es: " + "\"" + palabraCorta + "\"");
			System.out.println("La palabra mas larga es: " + "\"" + palabraLarga + "\"");
		}

		System.out.println("Introduce una palabra: ");
		String palabraBuscar = input.nextLine();

		// boolean palabraEncontrada = cadenaNueva.contains(palabraBuscar);
		
		// StringUtils.countMatches(String texto , StringSearcha palabra); devuelve el número
		// de veces que aparece la palabra en la cadena.
		int cantidad = StringUtils.countMatches(cadenaNueva,palabraBuscar);

		// OPERADOR TERNARIO:
		//String imprimir = palabraEncontrada ? "La palabra fue Encontrada" : "La palabra No esta en la cadena";
	
		System.out.printf("La palabra fue encontrada %s veces", cantidad);
		}
	}
}
