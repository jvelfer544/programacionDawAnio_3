package anio_3.unidad_2;
import java.util.Scanner;

public class fibonacci_20 {
/*
 * Escribe un programa que muestre los n primeros términos de la serie de
Fibonacci. El primer término de la serie de Fibonacci es 0, el segundo es 1 y el
resto se calcula sumando los dos anteriores, por lo que tendríamos que los
términos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144... El número n se debe
introducir por teclado.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce el valor de n: ");
		int n = input.nextInt();
		
		int a = 0;
		int b = 1;
		for (int i = 1; i <= n; i++) {

		    System.out.print(a + " ");

		    int siguiente = a + b;
		    a = b;
		    b = siguiente;
		}
		
		input.close();
	}

}
