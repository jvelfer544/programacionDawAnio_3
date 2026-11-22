package anio_3.unidad_3;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class tarea2PracticaEjer1b {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduce tú Email: ");
		String email = scan.nextLine();
		
		String regex = "^[\\w.-]{4,}@[a-zA-Z\\d]+\\.[a-zA-Z]{2,6}$";
		System.out.println(regex);
		if (email.isBlank() || !email.matches(regex)) {
			System.out.println("Email no válido");
			
		} else {
			// Devuelve el texto que hay antes de la @
			String sinFinalEmail = StringUtils.substringBefore(email, "@");
			System.out.println(sinFinalEmail);

			// devuelve el texto a partir de la @
			String finalEmail = email.substring(sinFinalEmail.length());
			System.out.println(finalEmail);

			String emailCifrado = "";

			for (int i = 0; i < sinFinalEmail.length(); i++) {
				char car = sinFinalEmail.charAt(i);

				if (i == 0 || i == sinFinalEmail.length() - 1) {
					emailCifrado += car;

				} else {
					emailCifrado += '*';

				}
			}
			
			emailCifrado += finalEmail;
			System.out.println(emailCifrado);
		}
	}

}
