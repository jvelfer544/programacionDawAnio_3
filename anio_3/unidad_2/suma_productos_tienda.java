package DAW.Anio_3;

import java.util.Scanner;

public class suma_productos_tienda {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float precio = 0;
        float suma = 0;
        boolean continuar = true;
        int contProductos = 0;

        while (continuar) {
            System.out.print("Introduce el precio de los productos:");
            precio = input.nextFloat();

            if (precio < 0) {
                continuar = false;
            } else {
                contProductos++;
                suma += precio;
            }
        }
            System.out.println("Detalles de la compra: ");
            System.out.println("La cantidad de productos comprados es: " + contProductos);
            System.out.printf("El precio total de la suma de todos los productos es: %.2f\n" , suma);
    }
}
