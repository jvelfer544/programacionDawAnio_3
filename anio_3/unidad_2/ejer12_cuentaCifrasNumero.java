package anio_3.unidad_2;
import java.util.Scanner;

public class ejer12_cuentaCifrasNumero {
/*
 * Realiza un programa que nos diga cuántos dígitos tiene un número entero que 
 * puede ser positivo o negativo. Se permiten números de hasta 5 dígitos.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Introduce un número positivo o negativo: ");
		int numero = input.nextInt();
		
		int cantidad = numero;
		int contador = 0;
		
		while(cantidad > 0) {
			
			cantidad /= 10;
			contador++;
		}
		
		System.out.println(contador);
		input.close();

	}

}
