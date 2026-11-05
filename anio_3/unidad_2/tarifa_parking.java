package anio_3.unidad_2;
import java.util.Scanner;

public class tarifa_parking {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Introduce los minutos de la estancia utilizado: ");
        int minutos = input.nextInt();
        float precio = 0;


        if(minutos < 0){
            System.out.println("Error, los minutos no pueden ser negativos ");

        }else if(minutos > 0 && minutos <= 30){
            System.out.println("Es gratis ");

        }else if(minutos > 30 && minutos <= 120) {
            precio = ((float) (minutos - 30) * 0.05f);

        }else if(minutos > 120){
            precio = ((float) 4.50 + (minutos - 120) * 0.03f);

        }
        if(precio > 15.00f){
            precio = 15.00f;
        }
            System.out.printf("El precio de los minutos euros es %.2f\n", precio);
            
            input.close();
    }
}
