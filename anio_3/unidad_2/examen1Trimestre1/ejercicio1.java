package anio_3.unidad_2.examen1Trimestre1;

import java.util.Scanner;

public class ejercicio1 {
	/*
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		double lm = 0;
		double prog = 0;
		double bd = 0;
		int num = -1;
		String lm1 = "";
		String prog1 = "";
		String bd1 = "";
		boolean salir = false;

		System.out.println("-----| Grado D.CFGS DAW |-----\n" + "| 1 - Lenguaje de Marcas              |\n"
				+ "| 2 - Proramación                     |\n" + "| 3 - Bases de datos                  |\n"
				+ "| 0 - Resumen y salir                 |\n");

		while (!salir) {

			System.out.print("Introduce una opción: ");
			num = input.nextInt();

			if (num == 1 || num == 2 || num == 3) {

				if (num == 1) {
					System.out.print("Introduce la nota: ");
					lm = input.nextDouble();
					

					if (!(lm >= 0 && lm <= 10)) {
						System.out.println("La nota introducida no es correcta");
					}



				} else if (num == 2) {
					System.out.print("Introduce la nota: ");
					prog = input.nextDouble();

					if (!(prog >= 0 && prog <= 10)) {
						System.out.println("La nota introducida no es correcta");
					}

				} else {
					System.out.print("Introduce la nota: ");
					bd = input.nextDouble();

					if (!(bd >= 0 && bd <= 10)) {
						System.out.println("La nota introducida no es correcta");
					}

				}

			} else if (num == 0) {
				salir = true;

			} else {
				System.out.println("Error, vuelve ha intentarlo");
			}
			

		}

		System.out.println("--------------------");

		if (salir) {			
			lm1 = String.valueOf(lm);
			if(lm1.equals("")) {
				lm1 = "NOEV";
			}
			prog1 = String.valueOf(lm);
			if(prog1.equals("")) {
				prog1 = "NOEV";
			}
			bd1 = String.valueOf(lm);
			if(bd1.equals("")) {
				bd1 = "NOEV";
			}
			
			
			System.out.println("Calificaciones Daw");
			System.out.println("Lenguaje de Marcas : " + lm1);
			System.out.println("Programacion: " + prog);
			System.out.println("Base de Datos: " + bd);
		}
		
		input.close();
	}

}
