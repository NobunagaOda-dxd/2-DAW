package PruebaInicial;
import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduce el primer lado: ");
            Integer l1 = sc.nextInt();
            System.out.println("Introduce el segundo lado: ");
            Integer l2 = sc.nextInt();
            System.out.println("Tu area es igual a = " + l1 * l2);
            System.out.println("Tu perimetro es igual a = " + l1 + l2);
        }
    }
}
