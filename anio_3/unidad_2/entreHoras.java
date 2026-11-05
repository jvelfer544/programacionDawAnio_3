package anio_3.unidad_2;
import java.util.Scanner;

public class entreHoras {
/*
    Crear un algoritmo que calucule la diferencia en minutos entre 2 horas introducidas por
    el usuario.
    Ejemplo: 12:45 y 17:15 -> 270 minutos (4 horas y 30 minutos)
 */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce la hora de inicio: ");
        int horaInicio = sc.nextInt();
        System.out.print("Introduce los minutos de inicio: ");
        int minutosInicio = sc.nextInt();

        System.out.print("Introduce la hora de fin: ");
        int horaFinal = sc.nextInt();
        System.out.print("Introduce los minutos de fin: ");
        int minutosFinal = sc.nextInt();

        int horaDiferencia = 0;
        int minutosDiferencia = 0;
        if(horaInicio < horaFinal){
            horaDiferencia = horaFinal - horaInicio;
            minutosDiferencia = minutosInicio - minutosFinal;
        }else{
            System.out.println("No se puede realizar el cálculo, la hora de inicio es mayor que la hora final ");
        }

        if(horaDiferencia < 59){
            minutosDiferencia *= horaDiferencia;
            if(minutosDiferencia > 59){
                horaDiferencia += minutosDiferencia;
            }
        }
        
        sc.close();
    }
}
