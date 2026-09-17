package PruebaInicial;
import java.util.Scanner;

public class prueba3 {
    public static void main(String[] args) {

        int[] arrayEnteros = new int[10];
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < arrayEnteros.length; i++) {
                System.out.println("Introduce los numeros = ");
                arrayEnteros[i] = sc.nextInt();
            }
        }
        System.out.println("desordenada");
        mostrar(arrayEnteros);

        for (int i = 0; i < arrayEnteros.length; i++) {
            for (int j = 0; j < arrayEnteros.length; j++) {
                int temp = 0;
                if (arrayEnteros[i] < arrayEnteros[j]) {
                    temp = arrayEnteros[i];
                    arrayEnteros[i] = arrayEnteros[j];
                    arrayEnteros[j] = temp;
                }
            }

        }
        System.out.println("ordenada");
        mostrar(arrayEnteros);
    }

    public static void mostrar(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
