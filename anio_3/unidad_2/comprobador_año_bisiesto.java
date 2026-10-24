package anio_3.unidad_2;
import java.util.Scanner;

public class comprobador_año_bisiesto {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Introduce un año para comprobar Si es o No bisiesto: ");
        int anio = input.nextInt();
        

        boolean esBisiesto = false;

        if(anio %4 == 0){
            if(anio %100 != 0){
                esBisiesto = true;
            }else if(anio %400 == 0){
                esBisiesto = true;
            }
        }

        if(esBisiesto){
            System.out.println("El año " + anio + " Si es Bisiesto ");
        }else{
            System.out.println("El año " + anio + " No es Bisiesto ");
        }
        input.close();
    }
}
