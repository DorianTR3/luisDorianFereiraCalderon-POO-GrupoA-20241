import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

//TIP podemos ganar el cisni
public class Main {
    public static void main(String[] args){

        //1.NullPointerException:
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Se ha producido un error");
        }
        //2. ArrayIndexOutOfBoundsException:
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se ha producido un error");
        }
        //3. ArithmeticException:
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido una ArithmeticException: división por cero");
        }
        //4. ClassNotFoundException:
        try {
            Class.forName("com.example.ClaseInexistente");
        } catch (ClassNotFoundException e) {
            System.out.println("Se ha producido una ClassNotFoundException");
        }

        //5. FileNotFoundException:
        try {
            FileReader fileReader = new FileReader("archivo.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException, trate de verificar que todo esta bien");
        }
        //7. NumberFormatException:
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Se ha producido una NumberFormatException");
        }
        //8. RuntimeException:
        try {
            arr = new int[5];
            System.out.println(arr[6]);
        } catch (RuntimeException e) {
            System.out.println("Se ha producido una RuntimeException");
        }
        //10. ConcurrentModificationException:




    }
}