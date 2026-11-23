package anio_3.unidad_3;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class tarea2PracticaEjer1a {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce los números de tú tarjeta bancaria");
		String numBancario = input.nextLine();
		input.close();
		
		char[] nums = numBancario.toCharArray();
		
//		for(int i=0; i < numBancario.length(); i++) {
//			nums[i] = numBancario.charAt(i);
//		}

		System.out.println(Arrays.toString(nums));
	}

}
