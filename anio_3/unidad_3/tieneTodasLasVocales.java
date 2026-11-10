package anio_3.unidad_3;

import java.util.Scanner;

public class tieneTodasLasVocales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String cadena = input.nextLine().trim().toLowerCase();
		
		String letra = "";
		int indice = 0;
		boolean vocalesEncontrado = true;
		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;
		
		while(indice < cadena.length() && vocalesEncontrado) {
			
			char car = cadena.charAt(indice);
			
			if(car == 'a' || car == 'á') {
				a++;
			} else {
				vocalesEncontrado = false;
			}
			
			if(car == 'e' || car == 'é') {
				e++;
			}else {
				vocalesEncontrado = false;
			}
			
			if(car == 'i' || car == 'í') {
				i++;
			}else {
				vocalesEncontrado = false;
			}
			
			if(car == 'o' || car == 'ó') {
				o++;
			} else {
				vocalesEncontrado = false;
			}
			
			if(car == 'u' || car == 'ú' || car == 'ü') {
				u++;
			}else {
				vocalesEncontrado = false;
			}
		
			
			indice++;
			if(a >= 1 && e >= 1 && i >= 1 && o >= 1 && u >= 1) {
				vocalesEncontrado = true;
			}
		}
		
		if(vocalesEncontrado) {
			System.out.println("Si es fullVocal");
		} else {
			System.out.println("No es fullVocal");
		}
		
	}

}
