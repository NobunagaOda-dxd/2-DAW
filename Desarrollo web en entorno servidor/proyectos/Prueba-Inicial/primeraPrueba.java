import java.util.Random;

/**
 * primeraPrueba
 */
public class primeraPrueba {

    public static void main(String[] args) {
        int[] array = new int[10];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = numeroParAleatorio();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int numeroParAleatorio() {
        Random rand = new Random();        
        int numeroParAleatorio = 0;
        numeroParAleatorio = rand.nextInt(100);

        do {
            numeroParAleatorio = rand.nextInt(100);
        } while (numeroParAleatorio % 2 != 0);

        return numeroParAleatorio;
        
    }
}