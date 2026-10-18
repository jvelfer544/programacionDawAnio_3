package tema2;
import java.util.Scanner;
public class capicua2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un número para ver si es capicua ");
//		int numero = input.nextInt();
		
		int numero = 1723;
		int nuevoNumero = numero;
		int resto = 0;
		
		while(nuevoNumero > 0) {
			
		nuevoNumero /= 10;
		resto = nuevoNumero;
		resto %= 10;
		
		System.out.println(nuevoNumero);
		System.out.println(resto);
		
		}
	}

}
