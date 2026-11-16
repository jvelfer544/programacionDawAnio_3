import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce tu nombre y apellidos: ");
        String nombreApellidos = input.nextLine().trim();

        String resultado = "";
        boolean nuevoNombre = true; 

        int índice = 0;
        while(índice < nombre apellidos.length()){
            char car = texto.charAt(indice);

            if (car == ' ') {
                resultado += car;
                nuevoNombre = true;

            } else if (nuevoNombre) {
                resultado += Character.toUpperCase(car);
                nuevoNombre = false;
            } else {
                resultado += Character.toLowerCase(car);
            }
           indice++;
        }

        System.out.println("Nombre formateado: " + resultado);
    }
}