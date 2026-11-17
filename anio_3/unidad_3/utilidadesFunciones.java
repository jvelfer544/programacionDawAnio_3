package anio_3.unidad_3;

import java.util.Scanner;

public class utilidadesFunciones {

	public static String concatenaCadenas (String cadena1, String cadena2) {
		String nuevaCadena = cadena1.concat(" " + cadena2);
		return nuevaCadena;

	}
	
	/**
	 * @param cadena
	 * @param patron
	 * @return si la cadena cumple con el patrón devuelve true, sino false
	 */
	public static boolean testRegex (String cadena, String patron) {
		return cadena.matches(patron);
	}

	/**
	 * @param num
	 * @return
	 */
	public static boolean esDigito (String num) {
		return num.matches("\\d+");
	}
	
	/**
	 * @param cadenaDni
	 * @return devuelve true si el dni cumple con el patrón
	 */
	public static boolean validarDni(String cadenaDni) {
	return cadenaDni.matches("[0-9]{8}-?[a-hj-np-uA-HJ-NP-U]");
	}
	
	/**
	 * @param codigoPostal
	 * @return
	 */
	public static boolean esCodigoPostal(String codigoPostal) {
		return codigoPostal.matches("\\d{5}");
		}
	
	/**
	 * @param numeroTel
	 * @return
	 */
	public static boolean esTelefono (String numeroTel) {
		return numeroTel.matches("(\\+34|0034)?\\s?[6789]\\d{8}");
	}
	
	public static boolean esEmail (String email) {
		return email.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}");
	}
	
	
	
	
}
