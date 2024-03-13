import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        boolean finalizar = false;
        int opcion;

        while (!finalizar) {
            System.out.println("-----------------------MENU----------------------");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Mostrar información de los usuarios");
            System.out.println("3. Agregar libro");
            System.out.println("4. Lista de libros");
            System.out.println("5. Rentar un libro");
            System.out.println("6. Comprar un libro");
            System.out.println("7. Listar libros rentados");
            System.out.println("8. Listar libros no rentados");
            System.out.println("9. Listar libros comprados");
            System.out.println("10. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    biblioteca.agregarUsuario();
                    break;
                case 2:
                    biblioteca.mostrarUsuarios();
                    break;
                case 3:
                    biblioteca.agregarLibro();
                    break;
                case 4:
                    biblioteca.mostrarLibros();
                    break;
                case 5:
                    biblioteca.rentarLibro();
                    break;
                case 6:
                    biblioteca.comprarLibro();
                    break;
                case 7:
                    biblioteca.mostrarLibrosRentados();
                    break;
                case 8:
                    biblioteca.mostrarLibrosNoRentados();
                    break;
                case 9:
                    biblioteca.mostrarLibrosComprados();
                    break;
                case 10:
                    finalizar = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 10.");
                    break;
            }
        }
    }
}