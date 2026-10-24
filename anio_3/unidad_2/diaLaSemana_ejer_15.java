package anio_3.unidad_2;
import java.util.Scanner;

public class diaLaSemana_ejer_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Introduce un dia de la semana: ");
		String diaSemana = input.nextLine();
		String asignatura = "";
		
		switch(diaSemana){
		case "lunes":
			asignatura = "ingles profesional";
			break;
		case "martes":
			asignatura = "programacion";
			break;
		case "miércoles":	
		case "miercoles":
			asignatura = "optativa";
			break;
		case "jueves":
			asignatura = "IPE2";
			break;
		case "viernes":
			asignatura = "Daw";
			break;
		default:
			System.out.println("El dia introducido no es válido");
			break;
		}
		
		System.out.println(asignatura);
		
		input.close();
		
	}
}
