package anio_3.unidad_2;
import java.util.Scanner;

public class numero_hyperpar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		long numOriginal = input.nextInt();
		long num = numOriginal;
		boolean esHyperpar = true;
		
		while(esHyperpar && num > 0) {
			num %= 10;
			int ultimaCifra = (int) num;
			num /= 10;
			
			if(ultimaCifra %2 != 0) {
				esHyperpar = false;
			}
		}
		
			if (esHyperpar) {
				System.out.println("Es hyperpar");
	
			} else {				
				System.out.println("No es hyperpar");
			}
	}

}
