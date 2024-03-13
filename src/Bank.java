import java.util.ArrayList;
import java.util.Random;
class Bank {
    private ArrayList<Employee> employees;

    public Bank() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String lastName, long accountNumber, char type) {
        accountNumber=BankAccount.CreacionaccountNumber();
        employees.add(new Employee(name, lastName, accountNumber, type));
    }

    public void showAllEmployees() {
        for (Employee employee : employees) {
            for (BankAccount account : employee.getAccounts()) {
                System.out.println("El empleado " + employee.getName() + " " + employee.getLastName() +
                        " tiene la cuenta " + account.getAccountNumber() + " con saldo de $" + account.getAmount() +
                        " y es de tipo " + account.getType());
            }
        }
    }

    public void showEmployeeInfo(long accountNumber) {
        for (Employee employee : employees) {
            for (BankAccount account : employee.getAccounts()) {
                if (account.getAccountNumber() == accountNumber) {
                    System.out.println("El empleado " + employee.getName() + " " + employee.getLastName() +
                            " tiene la cuenta " + account.getAccountNumber() + " con saldo de $" + account.getAmount() +
                            " y es de tipo " + account.getType());
                    return;
                }
            }
        }
        System.out.println("No se encontró ningún empleado con ese número de cuenta.");
    }

    public void depositToAccount(long accountNumber, double amount) {
        for (Employee employee : employees) {
            for (BankAccount account : employee.getAccounts()) {
                if (account.getAccountNumber() == accountNumber) {
                    account.deposit(amount);
                    System.out.println("Se depositaron $" + amount + " en la cuenta " + accountNumber);
                    return;
                }
            }
        }
        System.out.println("No se encontró ninguna cuenta con ese número.");
    }

    public void withdrawFromAccount(long accountNumber, double amount) {
        for (Employee employee : employees) {
            for (BankAccount account : employee.getAccounts()) {
                if (account.getAccountNumber() == accountNumber) {
                    account.withdraw(amount);
                    System.out.println("Se retiraron $" + amount + " de la cuenta " + accountNumber);
                    return;
                }
            }
        }
        System.out.println("No se encontró ninguna cuenta con ese número.");
    }
}
