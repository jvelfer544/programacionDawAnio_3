package anio_3.unidad_2;
import java.util.Scanner;

public class ejercicio_01 {
/*
 * Escribe un programa que cálcule el salario semanal de un trabajador teniendo
 * en cuenta que las horas ordinarias (40 primeras horas de trabajo) se pagan a 12
 * euros la hora. A partir de la hora 41, se pagan a 16 euros la hora.
 * Ejemplo 1:
 * Por favor, introduzca el número de horas trabajadas durante la semana: 36
 * El sueldo semanal que le corresponde es de 432 euros
 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Por favor, introduce el número de horas trabajadas durante la semana: ");
		float horas = input.nextFloat();
		
		float horasOrdinarias = 12;
		float horasExtras = 16;
		
		float sueldo = 0;
		
		input.close();
		
		if(horas < 0) {
			System.out.println("El número de horas introducida no es válida ");
			
		}else {
			
			if(horas > 0 && horas <= 40) {
				sueldo = horasOrdinarias * horas;
				
				} else {
					sueldo = horasOrdinarias * 40;
					
					sueldo += horasExtras * (horas - 40); 
					
				}
		}
			System.out.println("El sueldo semana que le corresponde es de " + sueldo + " euros");
	}
}
