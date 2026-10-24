package anio_3.unidad_2.ejer_examen_anio1;

public class ejercicio_2 {
/*
 * Mostrar por pantalla ordenados descendentemente los números enteros positivos menores que 100 
 * de tal forma que vayan 2 impares seguidos de un número par separados por coma “,”.  
 * Se comenzará por el número 100. De la siguiente forma: 
 * 100, 99, 97, 96, 95, 93, 92, 91, 89, 88, 87, 85, 84, 83, 81…  
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int aux = 100;
		System.out.print(aux);		
		
			while(aux > 0) {
				System.out.print(", ");
				System.out.print(aux -= 1);
				System.out.print(", ");
				System.out.print(aux -= 2);
				System.out.print(", ");
				System.out.print(aux -= 1);
				
			}
		
	}

}
