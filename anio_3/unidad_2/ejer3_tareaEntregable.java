package anio_3.unidad_2;

import java.util.Scanner;

public class ejer3_tareaEntregable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int suma = 0;
		int num = 0;
		boolean salir = false;
		int contador = 0;
		
		do {
			
			System.out.println("Introduca un número entero (número negativo para salir): ");
			num = input.nextInt();
			
			if(num < 0) {
				salir = true;
			}
			
			if(num > 0) {
				suma += num;
				contador++;
			}
		
		}while(num >= 0 && !salir);
		
		System.out.println("Ha introducido" + contador + " número válidos");
		System.out.println("La suma total acumulada es: " + suma);
	}

}
