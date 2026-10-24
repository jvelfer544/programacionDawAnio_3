package anio_3.unidad_2;
import java.util.Scanner;

public class ejercicio_23 {
/*
 * Escribe un programa que obtenga los números enteros comprendidos entre dos números 
 * introducidos por teclado y validados como distintos.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int num1 = 1;
		int num2 = 0;
		do {
			
				System.out.print("Introduce dos números: \n"
						+ " primer número: ");
				num1 = input.nextInt();
				System.out.println("segundo número: ");	
				num2 = input.nextInt();
				
			if(num1 == num2){
				System.out.println("Los número son iguales, intentaló de nuevo");
			} 
			
			 
		} while(num1 == num2);
		
		if(num1 > num2) {
			int aux = num1;
			num1 = num2;
			num2 = aux;
		}
		
		// Ajustamos el for para que no imprima los números introducidos.
			for(int i= num1 +1; i < num2; i++) {
				System.out.println("Sin incluir los números introducidos: ");
				System.out.print(i + " ");
			}
			
			System.out.println();
			// Si queremos que también imprima los números introducidos.
			for(int i= num1; i <= num2; i++) {
				System.out.println("Incluyendo los números introducidos: ");
				System.out.print(i + " ");
			}
			
			input.close();
	}
}
