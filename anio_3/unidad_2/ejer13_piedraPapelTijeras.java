package anio_3.unidad_2;

import java.util.Scanner;

public class ejer13_piedraPapelTijeras {
	/*
	 * Implementa un juego piedra, papel y tijeras. Utiliza las estructuras de
	 * decisión para resolverlo.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int opcionJugador = 0;
		
		boolean salir = false;
		
		do {
		System.out.println("Introduce una opción "
				         + "1.piedra\n"
				         + " 2.papel\n"
				         + " 3.tijeras\n "
				         + " 0.Salir");
		System.out.println("salir, para terminar el juego ");
		opcionJugador = input.nextInt();
		
		int opcionOrdenador = (int) (Math.random()*3+1);
		
		if(opcionJugador == opcionOrdenador) {
			System.out.println("empate");
			
		}else if(opcionJugador == 1 && opcionOrdenador == 2) {
			System.out.println("El ordendor gana");
		
		}else if(opcionJugador == 1 && opcionOrdenador == 3){
			System.out.println("El jugador gana");
			
		} else {
			salir = true;
			System.out.println("Saliendooooo");
			
		}
		
		}while(opcionJugador != 0 && !salir);
		
	}
}
