import java.util.Scanner;

public class prueba2 {
    public static void main(String[] args) {
        int sumaDePares = 0;

        int[] arrayEnteros = new int[10];
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < arrayEnteros.length; i++) {
                System.out.println("Introduce los numeros = ");
                arrayEnteros[i] = sc.nextInt();    
            }
        }
        for (int i = 0; i < arrayEnteros.length; i++) {
            if (arrayEnteros[i] % 2 == 0) {
                sumaDePares += arrayEnteros[i];
            }
        }

        System.out.println("La suma de pares es igual a = " + sumaDePares);
    }
}
