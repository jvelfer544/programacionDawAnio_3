package anio_3.unidad_3;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ejercicio_2Unidad_3VersionStringUtilsCapitalize {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce tu nombre y apellidos: ");
		// a) normalización
		String nombreOriginal = input.nextLine();
		String nombreNormalizado = "";
		// lo pasamos todo a minúscula, quitamos los espacios duplicados, iniciales y
		// finales y creamos un array con las distintas palabras
		String[] nombreArray = nombreOriginal.toLowerCase().trim().replaceAll("\\s+", " ").split(" ");
		for (String cadena : nombreArray) {
			// Ponemos la primera letra en mayúscula de cada parte y agregamos un espacio
			nombreNormalizado += StringUtils.capitalize(cadena) + " ";
		}
		// quitamos el último espacio
		nombreNormalizado = nombreNormalizado.trim();
		System.out.println("a) nombre normalizado. " + nombreNormalizado);
		// b) generación de alias
		String userNameSinTratar = nombreArray[0].charAt(0) + nombreArray[nombreArray.length - 2]
				+ ((nombreArray[nombreArray.length - 1].length() < 3) ? nombreArray[nombreArray.length - 1]
						: StringUtils.substring(nombreArray[nombreArray.length - 1], 0, 3));
		String userName = StringUtils.replaceChars(userNameSinTratar, "áéíóú", "aeiou");
		System.out.println("b) nombre de usuario. " + userName);
		// c) iniciales
		String iniciales = "";
		for (String cadena : nombreArray) {
			// Ponemos la primera letra en mayúscula de cada parte y agregamos un espacio
			iniciales += StringUtils.capitalize(cadena).charAt(0) + ".";
		}
		System.out.println("c) iniciales. " + iniciales);

	}

}
