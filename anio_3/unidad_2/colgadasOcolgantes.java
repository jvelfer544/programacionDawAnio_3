package anio_3.unidad_2;

import java.util.Scanner;

public class colgadasOcolgantes {
/*
 * Entrada La entrada comienza con un n´umero que indica la cantidad de casos de prueba
 *  que deben procesarse. Cada caso de prueba es una cadena compuesta por la palabra 
 *  “colgadas” o “colgantes”, quiz´a mezclando mayùsculas y minùsculas. Salida El programa 
 *  escribirà Bien si la palabra del caso de prueba es “colgadas” y Mal si la palabra es 
 *  “colgantes”, ignorando el uso de may´usculas. Entrada de ejemplo 3 colgadas COLGANTES ColgadaS
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Indica la cantidad de casos de prueba que deben procesarse: ");
		int num = input.nextInt();
		input.nextLine();
		
		int aux = 0;
		
		String cadena;
		
		boolean salir = false;
		
		while(!false && aux != num) {
			
			System.out.print("Escribe la palabra \"colgadas o colgantes\": " );
			cadena = input.nextLine().toLowerCase();
			aux++;
			
			if(cadena.equals("colgadas")) {
				System.out.println("Bien");
				
			} else if(cadena.equals("colgantes")){
				System.out.println("Mal");
				
			} else {
				System.out.println("La palabra introducida no es correcta");
				aux -= 1;
			}
			
			
			if(aux == num) {
				System.out.println("Fin de la comprobación");
				salir = true;
			}
		}	
	}
}
