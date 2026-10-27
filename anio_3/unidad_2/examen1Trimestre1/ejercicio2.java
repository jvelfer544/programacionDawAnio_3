package anio_3.unidad_2.examen1Trimestre1;

public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 100;	
		System.out.print(num + ", ");
		for(int i= num; i >= 0; i--) {
			
			if(i > 0) {
				i -= 1;
				System.out.print(i + ", ");
				i -= 2;
				System.out.print(i + ", ");
				i -= 1;
				System.out.print(i + ", ");				
			}else {
				System.out.print(i);				
				
			}
		}
		
	}
}
