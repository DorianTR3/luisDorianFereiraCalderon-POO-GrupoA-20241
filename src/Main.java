import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar información de todos los empleados");
            System.out.println("3. Mostrar información de un empleado");
            System.out.println("4. Depositar dinero en una cuenta");
            System.out.println("5. Retirar dinero de una cuenta");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Ingrese el apellido del empleado: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Ingrese el número de cuenta: ");
                    long accountNumber = scanner.nextLong();
                    System.out.print("Ingrese el tipo de cuenta (A, B o C): ");
                    char type = scanner.next().charAt(0);
                    bank.addEmployee(name, lastName, accountNumber, type);
                    break;
                case 2:
                    bank.showAllEmployees();
                    break;
                case 3:
                    System.out.print("Ingrese el número de cuenta del empleado: ");
                    long searchAccountNumber = scanner.nextLong();
                    bank.showEmployeeInfo(searchAccountNumber);
                    break;
                case 4:
                    System.out.print("Ingrese el número de cuenta en la que desea depositar: ");
                    long depositAccountNumber = scanner.nextLong();
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double depositAmount = scanner.nextDouble();
                    bank.depositToAccount(depositAccountNumber, depositAmount);
                    break;
                case 5:
                    System.out.print("Ingrese el número de cuenta de la que desea retirar: ");
                    long withdrawAccountNumber = scanner.nextLong();
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdrawFromAccount(withdrawAccountNumber, withdrawAmount);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
