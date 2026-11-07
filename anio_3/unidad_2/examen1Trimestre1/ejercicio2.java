package anio_3.unidad_2.examen1Trimestre1;

public class ejercicio2 {
/*
 * Mostrar por pantalla ordenados descendentemente los números enteros
positivos menores que 100 de tal forma que vayan 2 impares seguidos de un
número par separados por coma “,”.
Se comenzará por el número 100.
De la siguiente forma: 100, 99, 97, 96, 95, 93, 92, 91, 89, 88, 87, 85, 84, 83, 81…
 Par, impar, impar, par, impar, impar, par…
 */
	public static void main(String[] args) {

		int num = 100;
		int contadorImpares = 0;
		System.out.print(100);
		
		for (int i = 99; i > 0; i--) {
			if (i %2 != 0 && contadorImpares < 2) {
				System.out.print(", " + i);
				contadorImpares++;
				
			} else if (i %2 == 0 && contadorImpares >= 2) {
				System.out.print(", " + i);
				contadorImpares = 0;
				
			}
		}
		
	}
}
