package anio_3.unidad_2;

import java.util.Scanner;

public class ej9_piramide {
	/*
	 * Escribe un programa que pinte una pirámide rellena con un carácter
	 * introducido por teclado que podrá ser una letra, un número o los símbolos
	 * como *, +, € o $. El programa debe permitir al usuario mediante un menú
	 * elegir si el vértice de la pirámide está apuntando hacia arriba, hacia abajo
	 * o hacia la derecha
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int num = 10;

		for (int i = 0; i < num; i++) {

			for (int j = 0; j <= i; j++) {
				System.out.print("+ ");
			}
			System.out.println();
		}

		input.close();
	}

}
