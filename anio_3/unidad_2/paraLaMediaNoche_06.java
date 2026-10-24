package anio_3.unidad_2;

import java.util.Scanner;

public class paraLaMediaNoche_6 {
	/*
	 * Escribe un programa que dada una hora determinada (horas y minutos), calcule
	 * los segundo que faltan para llegar a la media noche.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce una hora: ");
		int hora = input.nextInt();
		System.out.print("Introduce los minutos: ");
		int minutos = input.nextInt();
		
		int segMinutos = minutos * 60;
		
		int mediaNoche = 24;
		
		int horasMediaNoche = (mediaNoche - hora) * 3600;		
		
		int resultado = horasMediaNoche - segMinutos;
		
		System.out.println(resultado + " segundos");
	}

}
