package anio_3.unidad_2;

import java.util.Scanner;

public class factorial {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Introduce un número entero para ver su factorial: ");
        int numero = input.nextInt();

        long bisiesto = 1;

        System.out.print(numero + "! = ");
        for(int i=1; i <= numero; i++){
            bisiesto *= i;

            if(i < numero){
                System.out.print(i + " x ");
            }else{
                System.out.print(i + " = ");
            }
        }
        System.out.print(bisiesto);
        
        input.close();
    }
}
