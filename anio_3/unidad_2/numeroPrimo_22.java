package anio_3.unidad_2;
import java.util.Scanner;

public class numeroPrimo_22 {
/*
 * Escribe un programa que diga si un número introducido por teclado es o no primo.
 * Un número primo es aquel que sólo es divisible entre él mismo y la unidad.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner input = new Scanner(System.in);
			
			System.out.println("Introduce un número para comprobar si es primo o no: ");
			int num = input.nextInt();
			int contador = 0;
			boolean esPrimo = true;
			
			// hacerlo con while
			
			int i = 1;
			
			while(esPrimo && i <= num) {
				
				if(num %i == 0) {
					contador++;
				}
				
				if(contador > 2) {
					esPrimo = false;
				}
				
				i++;
			}
			
			if(contador == 2) {
				esPrimo = true;
			} else {
				esPrimo = false;
			}
			
			if(!esPrimo) {
				System.out.println(num + " No es primo ");
				
			}else {
				System.out.println(num + " Si es primo ");
				
			}
			
			input.close();
	}

}
