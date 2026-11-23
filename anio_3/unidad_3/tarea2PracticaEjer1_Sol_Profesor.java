package anio_3.unidad_3;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class tarea2PracticaEjer1_Sol_Profesor {

	public static void main(String[] args) {
//		a) Pedir número de tarjeta de crédito por teclado: Recibe un número de
//	tarjeta de crédito de 16 dígitos (con o sin espacios) y muestra
//	únicamente los últimos 4 dígitos, sustituyendo los 12 primeros por
//	asteriscos en bloques de cuatro (ejemplo: **** **** **** 1234).
//	Si no se introduce una tarjeta válida debe mostrar el mensaje de error:
//	“Tarjeta no válida”
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce el número de tarjeta de crédito: ");
		// Obtiene la cadena del usuario
		String tarjetaCredito = input.nextLine();
		String tarjetaCreditoSinEspacios = tarjetaCredito.replaceAll("\\s+", "");
		if (tarjetaCreditoSinEspacios.matches("\\d{16}")) {
			// enmascaramos número
			System.out.println("**** **** **** " + StringUtils.substring(tarjetaCreditoSinEspacios, 12));
		} else {
			System.out.println("Tarjeta no válida");
		}
//		b) Pedir un email por teclado: Oculta el nombre de usuario de un email
//		mostrando solo la primera y última letra de la cuenta, rellenando la
//		parte intermedia con asteriscos (ejemplo: "manuel.garcia@gmail.com" -
//		> "m**********a@gmail.com").
//		Solo hay que validar que existe “cadenacualquiera”@
//		“cadenacualquiera”. “cadenacualquiera
//		Si no se introduce un email válido debe mostrar el mensaje de error:
//		“Email no válido”
		System.out.print("Introduce tu email: ");
		// Obtiene la cadena del usuario
		String email = input.nextLine();
		if (email.matches(".+@.+\\..+")) {
			int posArroba = email.indexOf('@');
			System.out.println("" + email.charAt(0) + StringUtils.repeat('*', posArroba - 2)
					+ email.charAt(posArroba - 1) + StringUtils.substring(email, posArroba));
		} else {
			System.out.println("Email no válido");
		}

	}

}
